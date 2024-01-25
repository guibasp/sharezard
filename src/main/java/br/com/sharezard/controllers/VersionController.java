package br.com.sharezard.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

import java.util.List;
import java.util.function.Consumer;

@RestController()
@RequestMapping(value = "/version")
public class VersionController {

    @GetMapping
    public Mono<String> version () {
        return Mono.just("0.0.1");
    }

    @GetMapping("/v1")
    public Flux<String> versions () {
        return Flux.just(new String [] {"0.0.1", "0.0.2"});
    }
}
