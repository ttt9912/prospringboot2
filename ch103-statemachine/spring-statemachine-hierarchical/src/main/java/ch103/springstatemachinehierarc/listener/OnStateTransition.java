package ch103.springstatemachinehierarc.listener;

import ch103.springstatemachinehierarc.statemachine.StateEnum;
import org.springframework.statemachine.annotation.OnTransition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnTransition
public @interface OnStateTransition {

    StateEnum[] source() default {};

    StateEnum[] target() default {};
}
