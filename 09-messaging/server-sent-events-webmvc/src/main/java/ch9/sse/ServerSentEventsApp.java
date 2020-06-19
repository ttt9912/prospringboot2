package ch9.sse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * SSE is supported in WebMVC since Spring 4.2
 *
 * Consider using webflux!
 *
 * ----------------------------------------------------------
 * asynchronous and streaming objects in Spring MVC 5.x.x.
 * ----------------------------------------------------------
 * # ResponseBodyEmitter
 * - http://localhost:8080/responsebody-emitter/rbe
 *
 * # SseEmitter
 * - http://localhost:8080/sse-emitter/stream-sse-mvc
 *
 * # StreamingResponseBody
 * - http://localhost:8080/streaming-responsebody/srb
 *
 * ----------------------------------------------------------
 * js consumers
 * ----------------------------------------------------------
 * http://localhost:8080
 *
 */
@SpringBootApplication
public class ServerSentEventsApp {

    public static void main(String[] args) {
        SpringApplication.run(ServerSentEventsApp.class, args);
    }
}
