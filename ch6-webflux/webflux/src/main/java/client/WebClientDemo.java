package client;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.data.ToDo;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/*
 * NOTE - Mono and Flux are not subscribed yet
 */
public class WebClientDemo {

    private final WebClient webClient = WebClient.create("http://localhost:8080");

    @Test
    void findById() {
        Mono<ToDo> result = webClient.get()
                .uri("/todo/{id}", "1")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(ToDo.class);
    }

    @Test
    void findAll() {
        Flux<ToDo> result = webClient.get()
                .uri("/todo")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ToDo.class);
    }
}
