package br.com.sharezard.services;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Brother;
import br.com.sharezard.repositories.BrotherRepository;
import br.com.sharezard.wire.out.BrotherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrotherService {

    private final BrotherRepository brotherRepository;

    public Mono<Brother> create (Brother brother) {
        if (!brother.isLegalAge())
            throw new ConflictException("O parca ai tem que ser de maior");
        return brotherRepository.save(brother);
    }

    public Flux<Brother> listAll() {
        return brotherRepository.findAll();
    }

    public Mono<Brother> findById(UUID id) {
        return brotherRepository.findById(id);
    }

    public Mono<Brother> update(UUID id, Brother brother) {
        return brotherRepository.findById(id)
                .map(b -> {
                    b.setName(brother.getName());
                    return b;
                })
                .flatMap(brotherRepository::save);
    }

    public Mono<Void> deleteBrother(UUID id) {
        return brotherRepository.deleteById(id);
    }
}
