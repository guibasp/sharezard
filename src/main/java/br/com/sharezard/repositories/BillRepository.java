package br.com.sharezard.repositories;

import br.com.sharezard.models.Bill;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BillRepository extends ReactiveCrudRepository<Bill, Long> {
}
