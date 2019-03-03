package client;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import webflux.data.ToDo;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/*
 * NOTE - Mono and Flux are not subscribed yet
 */
public class WebClientDemo {
    private static final WebClient webClient = WebClient.create("http://localhost:8080");

    static class FindById {
        public static void main(String[] args) {
            Mono<ToDo> result = webClient.get()
                    .uri("/todo/{id}", "1")
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(ToDo.class);
        }
    }

    static class FindAll {
        public static void main(String[] args) {
            Flux<ToDo> result = webClient.get()
                    .uri("/todo")
                    .accept(APPLICATION_JSON)
                    .retrieve()
                    .bodyToFlux(ToDo.class);
        }
    }
}