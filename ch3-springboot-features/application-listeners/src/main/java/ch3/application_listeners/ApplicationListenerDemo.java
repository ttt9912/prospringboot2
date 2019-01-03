package ch3.application_listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*
 * # ApplicationListener - Listening for event events
 * - ApplicationEvent (superclass)
 * - ApplicationEnvironmentPreparedEvent
 * - ApplicationPreparedEvent
 * - ApplicationReadyEvent
 * - ApplicationFailedEvent
 * - etc.
 */
@SpringBootApplication
public class ApplicationListenerDemo {
    private static final Logger log = LoggerFactory.getLogger(ApplicationListenerDemo.class);


    public static void main(String[] args) {
        ApplicationListener<ApplicationEvent> listener1 = event ->
                log.info("# ApplicationEvent > {}", event.getClass().getCanonicalName());
        
        ApplicationListener<ApplicationEnvironmentPreparedEvent> listener2 = event ->
                log.info("# ApplicationEnvironmentPreparedEvent > {}", event.getClass().getCanonicalName());

        ApplicationListener<ApplicationPreparedEvent> listener3 = event ->
                log.info("# ApplicationPreparedEvent > {}", event.getClass().getCanonicalName());

        ApplicationListener<ApplicationReadyEvent> listener4 = event ->
                log.info("# ApplicationReadyEvent > {}", event.getClass().getCanonicalName());

        ApplicationListener<ApplicationFailedEvent> listener5 = event ->
                log.info("# ApplicationFailedEvent > {}", event.getClass().getCanonicalName());

        new SpringApplicationBuilder(ApplicationListenerDemo.class)
                .listeners(listener1, listener2, listener3, listener4, listener5)
                .run(args);
    }
}


