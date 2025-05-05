package br.com.sharezard.repositories;

import br.com.sharezard.models.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, UUID> {
}
