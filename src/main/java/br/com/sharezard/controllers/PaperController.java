package br.com.sharezard.controllers;

import br.com.sharezard.adapters.BrotherAdapter;
import br.com.sharezard.adapters.PaperAdapter;
import br.com.sharezard.exceptions.NotFoundException;
import br.com.sharezard.services.BrotherService;
import br.com.sharezard.services.PaperService;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import br.com.sharezard.wire.out.PaperInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Paper;
import java.io.IOException;
import java.util.UUID;

@RestControllerAdvice
@RestController
@RequestMapping(value = "/papers")
@RequiredArgsConstructor
public class PaperController extends ResponseEntityExceptionHandler {

    private final BrotherAdapter brotherAdapter;
    private final BrotherService brotherService;
    private final PaperService paperService;
    private final PaperAdapter paperAdapter;

    @GetMapping("/")
    public Flux<BrotherResponse> all() {
        return brotherService.listAll().map(brotherAdapter::internalToOut);
    }

    @PostMapping("")
    public Mono<BrotherResponse> create(@RequestBody BrotherDTO brotherDTO) {
        var brother = brotherAdapter.inToInternal(brotherDTO);
        var monoBrother = brotherService.create(brother);
        return monoBrother.map(brotherAdapter::internalToOut);
    }


    @GetMapping("/{paper-code}")
    public Mono<PaperInfoResponse> get(@PathVariable("paper-code") String paperCode) throws IOException {
        return paperService.findById(paperCode)
                .map(paperAdapter::internalToOut)
                .switchIfEmpty(Mono.error(new NotFoundException("Paper does not exist")));
    }

    @PutMapping("/{id}")
    public Mono<BrotherResponse> update(@PathVariable("id") UUID id, @RequestBody BrotherDTO brotherDTO) {
        var brother = brotherAdapter.inToInternal(brotherDTO);
        return brotherService.update(id, brother).map(brotherAdapter::internalToOut);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") UUID id) {
        return brotherService.deleteBrother(id);
    }

}