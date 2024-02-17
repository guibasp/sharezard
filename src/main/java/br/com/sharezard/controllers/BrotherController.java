package br.com.sharezard.controllers;

import br.com.sharezard.adapters.BrotherAdapter;
import br.com.sharezard.exceptions.NotFoundException;
import br.com.sharezard.services.BrotherService;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestControllerAdvice
@RestController
@RequestMapping(value = "/brothers")
@RequiredArgsConstructor
public class BrotherController extends ResponseEntityExceptionHandler {

    private final BrotherAdapter brotherAdapter;
    private final BrotherService brotherService;

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


    @GetMapping("/{id}")
    public Mono<BrotherResponse> get(@PathVariable("id") UUID id) {
        return brotherService.findById(id)
                .map(brotherAdapter::internalToOut)
                .switchIfEmpty(Mono.error(new NotFoundException("Brother does not exist")));
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