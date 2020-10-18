package rsocket.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Controller
public class GreetingController {

    // request-stream model (Mono in, Flux out)
    @MessageMapping("greetings")
    Flux<GreetingResponse> greet(GreetingRequest request) {
        final Stream<GreetingResponse> stream = Stream.generate(() ->
                new GreetingResponse("hi " + request.getName() + " @ " + Instant.now()));

        return Flux.fromStream(stream)
                .take(10) // limit to 10 elements
                .delayElements(Duration.ofSeconds(1)); // slow results down
    }

}

