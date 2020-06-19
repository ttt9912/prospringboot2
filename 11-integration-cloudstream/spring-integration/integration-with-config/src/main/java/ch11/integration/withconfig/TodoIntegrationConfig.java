package ch11.integration.withconfig;

import ch11.integration.withconfig.data.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;

/*
 * # DirectChannel
 *  - MessageChannels offers several message channel types:
 *    direct, queue, publishSubscribe, executor, flux, rendezvous, ...
 *
 * # IntegrationFlow
 *  - chains MessageEndpoints stream-like
 *  - IntegrationFlows offers a fluent api to create an IntegrationFlow bean
 *  - registers all components like message channels, endpoints etc.
 *
 * ---------------------------------------------------------------------------------
 * Integration DSL
 * ---------------------------------------------------------------------------------
 * - simple way to build Spring Integration Message Flows by using the fluent
 *   Builder pattern
 */
@EnableIntegration
@Configuration
public class TodoIntegrationConfig {

    @Bean
    public DirectChannel input() {
        return MessageChannels.direct().get();
    }

    @Bean
    public IntegrationFlow simpleFlow() {
        return IntegrationFlows
                .from(input())
                .filter(Todo.class, Todo::isCompleted)
                .transform(Todo.class, Todo::getDescription)
                .handle(System.out::println)
                .get();
    }
}
