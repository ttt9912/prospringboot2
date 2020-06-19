package ch103.springstatemachinehierarc;

import ch103.springstatemachinehierarc.statemachine.EventEnum;
import ch103.springstatemachinehierarc.statemachine.StateEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
@EnableScheduling
public class App {

    @Autowired
    StateMachine<StateEnum, EventEnum> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    // @Scheduled(initialDelay = 5_000, fixedDelay = 60 * 60_000)
    public void withRestart() {
        System.out.println("\n--- E1");
        stateMachine.sendEvent(EventEnum.E1);       // STATE_INITIAL    -->     [STATE_PARENT, SUB_STATE_1]
        System.out.println("\n--- ESUB1");
        stateMachine.sendEvent(EventEnum.ESUB1);    //                  -->     [STATE_PARENT, SUB_STATE_2]
        System.out.println("\n--- ESUB2");
        stateMachine.sendEvent(EventEnum.ESUB2);    //                  -->     [STATE_PARENT, SUB_STATE_END]
        System.out.println("\n--- E2");
        stateMachine.sendEvent(EventEnum.E2);       //                  -->     STATE_INTERMED
        System.out.println("\n--- E3");
        stateMachine.sendEvent(EventEnum.E3);       //                  -->     STATE_END

        System.out.println("\n--- start()");
        stateMachine.start();                       // null             -->     STATE_INITIAL
    }

    @Scheduled(initialDelay = 5_000, fixedDelay = 60 * 60_000)
    public void withReset() {
        System.out.println("\n--- E1");
        stateMachine.sendEvent(EventEnum.E1);       // STATE_INITIAL    -->     [STATE_PARENT, SUB_STATE_1]
        System.out.println("\n--- ESUB1");
        stateMachine.sendEvent(EventEnum.ESUB1);    //                  -->     [STATE_PARENT, SUB_STATE_2]
        System.out.println("\n--- ESUB2");
        stateMachine.sendEvent(EventEnum.ESUB2);    //                  -->     [STATE_PARENT, SUB_STATE_END]
        System.out.println("\n--- E2");
        stateMachine.sendEvent(EventEnum.E2);       //                  -->     STATE_INTERMED
        System.out.println("\n--- RESET");
        stateMachine.sendEvent(EventEnum.RESET);    //                  -->     STATE_INITIAL

    }
}
