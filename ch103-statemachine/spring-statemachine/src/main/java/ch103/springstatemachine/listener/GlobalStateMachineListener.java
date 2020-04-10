package ch103.springstatemachine.listener;

import ch103.springstatemachine.statemachine.Events;
import ch103.springstatemachine.statemachine.States;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

public class GlobalStateMachineListener extends StateMachineListenerAdapter<States, Events> {

    @Override
    public void stateChanged(State<States, Events> from, State<States, Events> to) {
        System.out.printf("--- Transitioned from %s to %s%n",
                from == null ? "null" : from.getId(), to.getId());
    }
}
