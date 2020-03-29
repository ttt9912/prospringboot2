package ch9.sse_server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@Slf4j
@RestController
@RequestMapping("/sse-server")
public class ServerController {

    @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> "Flux - " + LocalTime.now().toString());
    }

    /*
     * using ServerSentEvent
     * - handle meta data
     * - media type “text/event-stream” not necessary
     */
    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<String>> streamEvents() {
        return Flux.just(1, 2, 3, 4, 5)
                .delayElements(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<String>builder()
                        .id(String.valueOf(sequence))
                        .event("periodic-event")
                        .data("SSE - " + LocalTime.now().toString())
                        .build());
    }

}
