package br.com.sharezard.controllers;

import br.com.sharezard.adapters.BrotherAdapter;
import br.com.sharezard.models.Brother;
import br.com.sharezard.repositories.BrotherRepository;
import br.com.sharezard.services.BrotherService;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping(value = "/brothers")
@RequiredArgsConstructor
class BrotherController {

    private final BrotherRepository brotherRepository;
    private final BrotherAdapter brotherAdapter;
    private final BrotherService brotherService;

    @GetMapping("/")
    public Flux<Brother> all() {
        return brotherRepository.findAll();
    }

    @PostMapping("")
    public Mono<BrotherResponse> create(@RequestBody BrotherDTO brotherDTO) {
        var brother = brotherAdapter.inToInternal(brotherDTO);
        var monoBrother = brotherService.create(brother);
        return monoBrother.map(brotherAdapter::internalToOut);
    }

    @GetMapping("/{id}")
    public Mono<Brother> get(@PathVariable("id") Long id) {
        return brotherRepository.findById(id);
    }

    @PutMapping("/{id}")
    public Mono<Brother> update(@PathVariable("id") Long id, @RequestBody Brother brother) {
        return brotherRepository.findById(id)
                .map(b -> {
                    b.setName(brother.getName());
                    return b;
                })
                .flatMap(brotherRepository::save);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return brotherRepository.deleteById(id);
    }

}