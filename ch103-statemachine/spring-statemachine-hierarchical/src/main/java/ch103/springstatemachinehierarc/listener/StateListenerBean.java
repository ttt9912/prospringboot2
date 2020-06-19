package ch103.springstatemachinehierarc.listener;

import ch103.springstatemachinehierarc.statemachine.EventEnum;
import ch103.springstatemachinehierarc.statemachine.StateEnum;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.OnStateMachineStart;
import org.springframework.statemachine.annotation.OnStateMachineStop;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

import static ch103.springstatemachinehierarc.statemachine.StateEnum.*;

@Component
@WithStateMachine
public class StateListenerBean {

    @OnStateMachineStart
    public void onStart(final StateMachine<StateEnum, EventEnum> stateMachine) {
        System.out.println(">>> Statemachine started - " + stateMachine.getUuid());
    }

    @OnStateMachineStop
    public void onStop(final StateMachine<StateEnum, EventEnum> stateMachine) {
        System.out.println(">>> Statemachine stopped - " + stateMachine.getUuid());
    }

    @OnTransition
    public void transition(final StateMachine<StateEnum, EventEnum> stateMachine) {
        System.out.println(">>> Transition");
    }

    @OnStateTransition(target = STATE_INITIAL)
    public void start(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - STATE_INITIAL");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = STATE_PARENT)
    public void stateparent(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - STATE_PARENT");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = SUB_STATE_INITIAL)
    public void substate(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - SUB_STATE_INITIAL");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = SUB_STATE_2)
    public void substate2(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - SUB_STATE_2");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = SUB_STATE_END)
    public void substateend(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - SUB_STATE_END");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = STATE_INTERMED)
    public void onIntermed(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - STATE_INTERMED");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(source = STATE_INTERMED, target = STATE_INITIAL)
    public void onReset(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - RESET: STATE_INTERMED -> STATE_INITIAL");
        System.out.println("ExtendedState: " + extendedState);
    }

    @OnStateTransition(target = STATE_END)
    public void stateend(final ExtendedState extendedState) {
        System.out.println(">>> OnStateTransition - STATE_END");
        System.out.println("ExtendedState: " + extendedState);
    }
}
