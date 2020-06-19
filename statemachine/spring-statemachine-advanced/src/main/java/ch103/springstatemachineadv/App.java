package ch103.springstatemachineadv;

import ch103.springstatemachineadv.statemachine.EventEnum;
import ch103.springstatemachineadv.statemachine.StateEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.StateMachine;

import static ch103.springstatemachineadv.statemachine.EventEnum.*;

/*
 * # StateContext       - snapshot of the statemachine, accessible within Actions, Transitions and Guards
 *
 * # Actions            - attached to States or Transitions
 *
 * # Global Listeners   - on Transitions for Security & Logging
 *
 * # Extended state     - store additional information to StateContext
 *
 * # Guards             - validate some data before a transition to a state is executed
 *
 * Further Topics
 * - Hierarchical States
 * - Junctions (Choices)
 * - Fork
 * - Join
 *
 * https://www.baeldung.com/spring-state-machine
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner run(StateMachine<StateEnum, EventEnum> stateMachine) {
        return args -> {
            stateMachine.start();                   // Sets STATE_INITIAL
            stateMachine.sendEvent(EVENT1);         // STATE_INITIAL --> STATE1
            stateMachine.sendEvent(EVENT2);         // STATE1 --> STATE2
            stateMachine.sendEvent(EVENT_END);      // STATE2 --> STATE_FIN
        };
    }
}
