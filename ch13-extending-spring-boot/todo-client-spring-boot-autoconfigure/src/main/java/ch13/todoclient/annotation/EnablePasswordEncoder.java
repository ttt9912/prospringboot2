package ch13.todoclient.annotation;

import ch13.todoclient.security.PasswordEncoderImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * @Enable* feature
 * - hide all the boilerplate configuring
 *
 * - import the ImportSelector implementation
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(PasswordEncoderImportSelector.class)
public @interface EnablePasswordEncoder {
    Algorithm algorithm() default Algorithm.BCRYPT;
}
