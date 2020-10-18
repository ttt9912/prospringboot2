package rsocket.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import reactor.core.publisher.Flux;

import java.io.IOException;

/*
 * Start RSocketReactiveApp
 *
 * ----------------------------------------
 * Retrosocket
 * ----------------------------------------
 * Feign like RSocket client
 *
 * https://github.com/spring-projects-experimental/spring-retrosocket
 *
 */
@SpringBootApplication
public class RSocketClientApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RSocketClientApp.class, args);
        System.in.read(); // prevent termination
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> client(RSocketRequester requester) {
        return args -> {

            final Flux<GreetingResponse> responseStream =
                    requester.route("greetings")
                            .data(new GreetingRequest("Mark"))
                            .retrieveFlux(GreetingResponse.class);

            responseStream.subscribe(System.out::println);
        };
    }

    @Bean
    RSocketRequester rSocketRequester(RSocketRequester.Builder builder) {
        return builder.connectTcp("localhost", 8888)
                .block();
    }


}
