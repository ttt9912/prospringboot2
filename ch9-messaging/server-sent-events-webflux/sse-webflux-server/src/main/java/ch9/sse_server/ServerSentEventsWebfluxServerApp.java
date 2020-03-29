package ch9.sse_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * go to:
 *
 * - http://localhost:8080/sse-server/stream-flux
 * - consume a Flux<String>
 *
 * - http://localhost:8080/sse-server/stream-sse
 * - consume a Flux<ServerSentEvent<String>>
 */
@SpringBootApplication
public class ServerSentEventsWebfluxServerApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerSentEventsWebfluxServerApp.class, args);
    }
}
