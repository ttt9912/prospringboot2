package ch11.integration.withannotations;

import ch11.integration.withannotations.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/*
 * ---------------------------------------------------------------------------------
 * Flow Overview
 * ---------------------------------------------------------------------------------
 * MessageChannel[input] -> TodoFilter -> MessageChannel[toTransform] -> TodoTransformer -> MessageChannel[toLog] -> TodoServiceActivator
 *
 * ---------------------------------------------------------------------------------
 * Message Endpoint annotations
 * ---------------------------------------------------------------------------------
 * one annotation for each message endpoint type (see Notes)
 * - @Filter
 * - @Transformer
 * - @ServiceActivator
 * - @Splitter
 * - @Router
 * - etc.
 */
@Slf4j
@EnableIntegration
@Configuration
public class TodoIntegrationConfig {

    @Bean
    public MessageChannel input() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel toTransform() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel toLog() {
        return new DirectChannel();
    }

    @MessageEndpoint
    class TodoFilter {

        @Filter(inputChannel = "input", outputChannel = "toTransform")
        public boolean process(Todo todo) {
            return todo.isCompleted();
        }
    }

    @MessageEndpoint
    class TodoTransformer {

        @Transformer(inputChannel = "toTransform", outputChannel = "toLog")
        public String process(Todo message) {
            return message.getDescription().toUpperCase();
        }
    }

    @MessageEndpoint
    class TodoServiceActivator {

        @ServiceActivator(inputChannel = "toLog")
        public void process(String message) {
            log.info(message);
        }
    }

}
