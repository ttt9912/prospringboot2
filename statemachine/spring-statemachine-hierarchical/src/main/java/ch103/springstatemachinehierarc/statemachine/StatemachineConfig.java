package ch103.springstatemachinehierarc.statemachine;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

@Configuration
@EnableStateMachine
public class StatemachineConfig extends EnumStateMachineConfigurerAdapter<StateEnum, EventEnum> {

    @Override
    public void configure(final StateMachineConfigurationConfigurer<StateEnum, EventEnum> config) throws Exception {
        config.withConfiguration()
                .autoStartup(true);
    }

    @Override
    public void configure(final StateMachineStateConfigurer<StateEnum, EventEnum> states) throws Exception {
        states.withStates()
                .initial(StateEnum.STATE_INITIAL)
                .state(StateEnum.STATE_PARENT)
                .state(StateEnum.STATE_INTERMED)
                .end(StateEnum.STATE_END)
                .and()
                .withStates()
                .parent(StateEnum.STATE_PARENT)
                .initial(StateEnum.SUB_STATE_INITIAL)
                .state(StateEnum.SUB_STATE_2)
                .end(StateEnum.SUB_STATE_END);
    }


    // TODO: use withInternal??
    @Override
    public void configure(final StateMachineTransitionConfigurer<StateEnum, EventEnum> transitions) throws Exception {
        transitions
                .withExternal()
                .source(StateEnum.STATE_INITIAL).target(StateEnum.STATE_PARENT)
                .event(EventEnum.E1)

                .and().withExternal()
                .source(StateEnum.SUB_STATE_INITIAL).target(StateEnum.SUB_STATE_2)
                .event(EventEnum.ESUB1)
                .action(updateExtendedState("a"))

                .and().withExternal()
                .source(StateEnum.SUB_STATE_2).target(StateEnum.SUB_STATE_END)
                .event(EventEnum.ESUB2)
                .action(updateExtendedState("b"))

                .and().withExternal()
                .source(StateEnum.STATE_PARENT).target(StateEnum.STATE_INTERMED)
                .event(EventEnum.E2)

                .and().withExternal()
                .source(StateEnum.STATE_INTERMED).target(StateEnum.STATE_INITIAL)
                .event(EventEnum.RESET)
                .action(clearExtendedState())

                .and().withExternal()
                .source(StateEnum.STATE_INTERMED).target(StateEnum.STATE_END)
                .event(EventEnum.E3);
    }

    private Action<StateEnum, EventEnum> updateExtendedState(final String key) {
        return context -> context.getExtendedState().getVariables().put(key, Math.random());
    }

    private Action<StateEnum, EventEnum> clearExtendedState() {
        return context -> context.getExtendedState().getVariables().clear();
    }
}
