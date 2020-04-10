package ch103.springstatemachine.listener;

import org.springframework.statemachine.annotation.*;
import org.springframework.stereotype.Component;

/*
 * ExtendedState parameter is optional
 *
 * all lifecycle annotations: org.springframework.statemachine.annotation
 */
@Component
@WithStateMachine
public class StateListenerBean {

    @OnStateMachineStart
    public void onStart() {
        System.out.println(">>> Statemachine started");
    }

    @OnStateChanged
    public void onChange() {
        System.out.println(">>> State Changed");
    }

    @OnEventNotAccepted
    public void onEventNotAccepted() {
        System.out.println(">>> Event not accepted");
    }

    @OnTransition(target = "STATE1")
    public void toState1() {
        System.out.println(">>> transition TO STATE1");
    }

    @OnTransition(source = "STATE2")
    public void fromState2() {
        System.out.println(">>> transition FROM STATE2");
    }
}
