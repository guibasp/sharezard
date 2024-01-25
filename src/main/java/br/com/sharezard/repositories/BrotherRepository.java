package br.com.sharezard.repositories;

import br.com.sharezard.models.Brother;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BrotherRepository extends ReactiveCrudRepository<Brother, Long> {
}
