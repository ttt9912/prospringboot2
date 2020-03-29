package ch9.sse_client.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/*
 * ServerSentEvent wrapper - can be bypassed if we don't need the event metadata
 *
 * errors - automatically throws a WebClientResponseException if we receive a 4xx or 5xx
 *          response unless we handle the scenarios adding an onStatus statement
 */
@Slf4j
@RestController
@RequestMapping("/sse-consumer")
public class ClientController {
    private final WebClient webClient = WebClient.create("http://localhost:8080/sse-server");


    // ------------------------------------------------------
    // subscribe to Flux<ServerSentEvent<String>>
    // ------------------------------------------------------
    @GetMapping("/sse-flux")
    public String launchSSEFromSSEWebClient() {
        consumeSSE();
        return "LAUNCHED EVENT CLIENT!!! Check the logs...";
    }

    @Async
    public void consumeSSE() {
        ParameterizedTypeReference<ServerSentEvent<String>> type = new ParameterizedTypeReference<>() {
        };

        Flux<ServerSentEvent<String>> sseStream = webClient.get()
                .uri("/stream-sse")
                .retrieve()
                .bodyToFlux(type);

        sseStream.subscribe(
                content -> log.info("Received SSE: name[{}], id [{}], content[{}] ", content.event(), content.id(), content.data()),
                error -> log.error("Error receiving SSE", error),
                () -> log.info("Completed!!!"));
    }


    // ------------------------------------------------------
    // subscribe to Flux<String>
    // ------------------------------------------------------
    @GetMapping("/flux")
    public String launchcFluxFromSSEWebClient() {
        consumeFlux();
        return "LAUNCHED EVENT CLIENT!!! Check the logs...";
    }

    @Async
    public void consumeFlux() {
        Flux<String> stringStream = webClient.get()
                .uri("/stream-flux")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);

        stringStream.subscribe(
                content -> log.info("Received content: {} ", content),
                error -> log.error("Error retrieving content", error),
                () -> log.info("Completed!!!"));
    }


    // ------------------------------------------------------
    // subscribe to Flux<String> and
    // map to Flux<ServerSentEvent<String>>
    // ------------------------------------------------------
    @GetMapping("/flux-to-sse")
    public String launchFluxFromFluxWebClient() {
        stringFluxToSseFlux();
        return "LAUNCHED EVENT CLIENT!!! Check the logs...";
    }

    @Async
    public void stringFluxToSseFlux() {
        ParameterizedTypeReference<ServerSentEvent<String>> type = new ParameterizedTypeReference<>() {
        };

        Flux<ServerSentEvent<String>> eventStream = webClient.get()
                .uri("/stream-flux")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(type);

        eventStream.subscribe(
                content -> log.info("Received SSE: name[{}], id [{}], content[{}] ", content.event(), content.id(), content.data()),
                error -> log.error("Error receiving SSE", error),
                () -> log.info("Completed!!!"));
    }
}
