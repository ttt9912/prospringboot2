package ch103.springstatemachine;

import ch103.springstatemachine.statemachine.Events;
import ch103.springstatemachine.statemachine.States;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.statemachine.StateMachine;

/*
 * https://projects.spring.io/spring-statemachine/
 *
 * Listen to State Machine events
 * - With annotations on @WithStateMachine-Bean
 * - add listener to statemaching
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    @Order(2)
    CommandLineRunner run(StateMachine<States, Events> stateMachine) {
        return args -> {
            stateMachine.start();                   // Sets STATE1
            stateMachine.sendEvent(Events.EVENT1);  // STATE1 --> STATE2
            stateMachine.sendEvent(Events.EVENT2);  // STATE2 --> STATE1
            stateMachine.stop();
        };
    }
}
