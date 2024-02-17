package br.com.sharezard.services;

import br.com.sharezard.controllers.BrotherController;
import br.com.sharezard.models.Brother;
import br.com.sharezard.repositories.BrotherRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(value = SpringExtension.class)
@WebFluxTest(BrotherController.class)

public class BrotherServiceTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    private BrotherRepository brotherRepository;
    
    @Test
    public void testGetEmployeeById() {
        var uuid = UUID.randomUUID();
        var brother = Brother.builder().name("Guilherme").brotherId(uuid).build();
        var brotherMono = Mono.just(brother);

        when(brotherRepository.findById(uuid)).thenReturn(brotherMono);

        webTestClient.get()
                .uri("/brothers/" + uuid)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(uuid.toString());
    }

}
