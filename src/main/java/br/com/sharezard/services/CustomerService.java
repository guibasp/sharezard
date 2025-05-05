package br.com.sharezard.services;

import br.com.sharezard.models.Brother;
import br.com.sharezard.models.Customer;
import br.com.sharezard.repositories.CustomerRepository;
import br.com.sharezard.utils.ObjectUpdater;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.util.internal.ObjectUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectUpdater<Customer> customerUpdater;

    public Mono<Customer> create (Customer customer) {
        return customerRepository.save(customer);
    }

    public Flux<Customer> listAll() {
        return customerRepository.findAll();
    }

    public Mono<Customer> findById(UUID id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> update(UUID id, Customer customer) {
        return customerRepository.findById(id)
                .map(b -> customerUpdater.updateObject(b, customer))
                .flatMap(customerRepository::save);
    }

    public Mono<Void> deleteBrother(UUID id) {
        return customerRepository.deleteById(id);
    }
}
