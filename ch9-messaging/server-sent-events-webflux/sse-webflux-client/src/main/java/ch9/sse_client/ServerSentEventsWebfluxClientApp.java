package ch9.sse_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/*
 * 1.) start ServerSentEventsWebfluxServerApp
 *
 * 2.) go to:
 *
 * http://localhost:8082/sse-consumer/sse-flux
 * - subscribe to Flux<ServerSentEvent<String>>

 * http://localhost:8082/sse-consumer/flux
 * - subscribe to Flux<String>
 *
 * http://localhost:8082/sse-consumer/flux-to-sse
 * - subscribe to Flux<String>
 * - map to Flux<ServerSentEvent<String>>
 */
@SpringBootApplication
@EnableAsync
public class ServerSentEventsWebfluxClientApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerSentEventsWebfluxClientApp.class, args);
    }
}
