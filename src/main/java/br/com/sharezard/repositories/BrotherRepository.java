package br.com.sharezard.repositories;

import br.com.sharezard.models.Brother;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface BrotherRepository extends ReactiveCrudRepository<Brother, UUID> {
}
