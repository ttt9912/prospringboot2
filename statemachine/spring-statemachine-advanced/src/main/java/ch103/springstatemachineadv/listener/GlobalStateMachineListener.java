package ch103.springstatemachineadv.listener;

import ch103.springstatemachineadv.statemachine.EventEnum;
import ch103.springstatemachineadv.statemachine.StateEnum;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

public class GlobalStateMachineListener extends StateMachineListenerAdapter<StateEnum, EventEnum> {

    @Override
    public void stateChanged(State<StateEnum, EventEnum> from, State<StateEnum, EventEnum> to) {
        System.out.printf("--- Transitioned from %s to %s%n",
                from == null ? "null" : from.getId(), to.getId());
    }
}
