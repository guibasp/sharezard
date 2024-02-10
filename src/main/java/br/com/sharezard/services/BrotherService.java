package br.com.sharezard.services;

import br.com.sharezard.exceptions.ConflictException;
import br.com.sharezard.models.Brother;
import br.com.sharezard.repositories.BrotherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BrotherService {

    private final BrotherRepository brotherRepository;

    public Mono<Brother> create (Brother brother) {
        if (!brother.isLegalAge())
            throw new ConflictException("O parca ai tem que ser de maior");
        return brotherRepository.save(brother);
    }

}
