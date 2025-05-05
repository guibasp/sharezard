package br.com.sharezard.controllers;

import br.com.sharezard.adapters.BrotherAdapter;
import br.com.sharezard.adapters.CustomerAdapter;
import br.com.sharezard.adapters.PaperAdapter;
import br.com.sharezard.exceptions.NotFoundException;
import br.com.sharezard.services.BrotherService;
import br.com.sharezard.services.CustomerService;
import br.com.sharezard.services.PaperService;
import br.com.sharezard.wire.in.BrotherDTO;
import br.com.sharezard.wire.in.CustomerDTO;
import br.com.sharezard.wire.out.BrotherResponse;
import br.com.sharezard.wire.out.CustomerResponse;
import br.com.sharezard.wire.out.PaperInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

@RestControllerAdvice
@RestController
@RequestMapping(value = "/customers")
@RequiredArgsConstructor
public class CustomerController extends ResponseEntityExceptionHandler {

    private final CustomerService customerService;
    private final CustomerAdapter customerAdapter;

    @GetMapping("/")
    public Flux<CustomerResponse> all() {
        return customerService.listAll().map(customerAdapter::internalToOut);
    }

    @PostMapping("")
    public Mono<CustomerResponse> create(@RequestBody CustomerDTO customerDTO) {
        var customer = customerAdapter.inToInternal(customerDTO);
        return customerService.create(customer)
                .map(customerAdapter::internalToOut);
    }


    @GetMapping("/{id}")
    public Mono<CustomerResponse> get(@PathVariable("id") UUID customerId) throws IOException {
        return customerService.findById(customerId)
                .map(customerAdapter::internalToOut)
                .switchIfEmpty(Mono.error(new NotFoundException("Customer does not exist")));
    }

    @PutMapping("/{id}")
    public Mono<CustomerResponse> update(@PathVariable("id") UUID customerId, @RequestBody CustomerDTO customerDTO) {
        var customer = customerAdapter.inToInternal(customerDTO);
        return customerService.update(customerId, customer)
                .map(customerAdapter::internalToOut)
                .switchIfEmpty(Mono.error(new NotFoundException("Customer does not exist")));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") UUID id) {
        return customerService.deleteBrother(id);
    }

}