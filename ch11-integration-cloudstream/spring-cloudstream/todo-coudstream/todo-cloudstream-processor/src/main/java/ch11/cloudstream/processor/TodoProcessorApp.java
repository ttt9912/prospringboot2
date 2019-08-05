package ch11.cloudstream.processor;

import ch11.cloudstream.processor.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/*
 * ---------------------------------------------------------------------------------
 * Processor
 * ---------------------------------------------------------------------------------
 * - consumes from input channel, publishes to output channel
 * - Creates exchanges 'newTodo' and 'completedTodo' on Rabbit
 * - Creates MessageChannel beans 'input' and 'output'
 *
 * ---------------------------------------------------------------------------------
 * Run
 * ---------------------------------------------------------------------------------
 * # start rabbit
 * docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
 *
 * # admin console
 * localhost:15672
 * login: guest/guest
 *
 * ---------------------------------------------------------------------------------
 * See messages in Browser
 * ---------------------------------------------------------------------------------
 * -> Pro Spring Boot 2 p.423
 *
 * ---------------------------------------------------------------------------------
 * Rabbit
 * ---------------------------------------------------------------------------------
 * - TodoProcessor stream creates the input and output exchanges and the
 *   input.anonymous.* queue
 *
 * - Create a Queue in the Browser and publish/consumer messages
 *   (Pro Spring Boot 2 p.423)
 */
@Slf4j
@SpringBootApplication
public class TodoProcessorApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoProcessorApp.class, args);
    }

    /*
     * Send messages programmatically
     * - alternative: send in Rabbit Console
     *
     * MessageChannel 'input' is created by spring
     */
    @Bean
    public ApplicationRunner send(MessageChannel input) {
        return args -> {
            input.send(MessageBuilder
                    .withPayload(new Todo("Read a Book"))
                    .build());
        };
    }
}
