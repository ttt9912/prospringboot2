package ch11.cloudstream.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * Source
 * ---------------------------------------------------------------------------------
 * - no input channel, publishes to output channel
 * - Creates exchange 'newTodo' on Rabbit
 * - Creates MessageChannel bean 'output'
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
 * Rabbit
 * ---------------------------------------------------------------------------------
 * - TodoSource sends a Message to Rabbit Topic Exchange every second
 *
 * - Create a Queue in the Browser and listen for messages
 *   (Pro Spring Boot 2 p.416)
 */
@SpringBootApplication
public class TodoSourceApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoSourceApp.class, args);
    }
}
