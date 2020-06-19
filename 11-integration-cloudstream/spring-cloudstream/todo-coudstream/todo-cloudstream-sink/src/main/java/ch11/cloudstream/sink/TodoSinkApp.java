package ch11.cloudstream.sink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * Sink
 * ---------------------------------------------------------------------------------
 * - consumes from input channel, no output channel
 * - Creates exchange 'completedTodo' on Rabbit
 * - Creates MessageChannel bean 'input'
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
 * Rabbit todo
 * ---------------------------------------------------------------------------------
 * - TodoSource sends a Message to Rabbit Topic Exchange every second
 *
 * - Create a Queue in the Browser and listen for messages
 *   (Pro Spring Boot 2 p.416)
 */
@SpringBootApplication
public class TodoSinkApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoSinkApp.class, args);
    }
}
