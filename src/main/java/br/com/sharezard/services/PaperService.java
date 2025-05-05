package br.com.sharezard.services;

import br.com.sharezard.logic.Scrapper;
import br.com.sharezard.models.Brother;
import br.com.sharezard.models.PaperInfo;
import br.com.sharezard.repositories.BrotherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaperService {

    private final BrotherRepository brotherRepository;

    public static <T> Flux<T> update(String paperCode, Brother brother) {
        return null;
    }

    public Mono<Brother> create (Brother brother) {
        brother.validateLegalPerson();
        return brotherRepository.save(brother);
    }

    public Flux<Brother> listAll() {
        return brotherRepository.findAll();
    }

    public Mono<PaperInfo> findFIIByCode(String paperCode) throws IOException {
        return Mono.just(Scrapper.extractFIIs(paperCode));
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
