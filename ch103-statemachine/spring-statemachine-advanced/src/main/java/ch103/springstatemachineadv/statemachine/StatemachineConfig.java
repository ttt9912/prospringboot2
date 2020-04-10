package ch103.springstatemachineadv.statemachine;

import ch103.springstatemachineadv.listener.GlobalStateMachineListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;

import static ch103.springstatemachineadv.statemachine.EventEnum.*;
import static ch103.springstatemachineadv.statemachine.StateEnum.*;

/*
 * Configures a bean of type ObjectStateMachine<S, E>
 *
 * -----------------------------------
 * StateContext
 * -----------------------------------
 * - representing of a current context, snapshot of where state machine is
 * - passed into various methods of Transitions, Actions and Guards in order to get access
 *   to event headers and ExtendedState
 */
@Configuration
@EnableStateMachine
public class StatemachineConfig extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

    @Override
    public void configure(final StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
        config.withConfiguration()
                .listener(new GlobalStateMachineListener());
    }

    @Override
    public void configure(final StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
        states.withStates()
                .initial(STATE_INITIAL)
                .end(STATE_FIN)
                .state(STATE1)
                .stateEntry(STATE1, action(), errorAction())    // attach Actions to state
                .stateDo(STATE1, action(), errorAction())
                .stateExit(STATE1, action(), errorAction())
                .state(STATE2);
    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
        transitions.withExternal()
                .source(STATE_INITIAL).target(STATE1).event(EVENT1).action(extendedStateAction()) // action on Transition
                .and().withExternal()
                .source(STATE1).target(STATE2).event(EVENT2).guard(simpleGuard()) // guard for Transition
                .and().withExternal()
                .source(STATE2).target(STATE_FIN).event(EVENT_END);
    }

    /*
     * Actions - attached to transitions or states
     */
    @Bean
    public Action<StateEnum, EventEnum> action() {
        return stateContext -> System.out.println(">>> Action - " +
                " target=" + stateContext.getTarget().getId() +
                " event=" + stateContext.getEvent() +
                " extendedState=" + stateContext.getExtendedState());
    }

    @Bean
    public Action<StateEnum, EventEnum> errorAction() {
        return stateContext -> System.out.println(">>> ERROR" +
                stateContext.getException());
    }

    /*
     * Extended state - store additional information
     */
    @Bean
    public Action<StateEnum, EventEnum> extendedStateAction() {
        System.out.println(">>> Action - increment counter");
        return stateContext -> {
            int approvals = (int) stateContext.getExtendedState().getVariables()
                    .getOrDefault("counter", 0);
            approvals++;
            stateContext.getExtendedState().getVariables().put("counter", approvals);
        };
    }

    /*
     * Guard
     */
    @Bean
    public Guard<StateEnum, EventEnum> simpleGuard() {
        return ctx -> {
            final int counter = (int) ctx.getExtendedState().getVariables().getOrDefault("counter", 0);

            if (counter > 0) {
                System.out.println(">>> Guard - passed, counter=" + counter);
                return true;
            }

            System.out.println(">>> Guard - not passed, counter=" + counter);
            return false;
        };
    }

}
