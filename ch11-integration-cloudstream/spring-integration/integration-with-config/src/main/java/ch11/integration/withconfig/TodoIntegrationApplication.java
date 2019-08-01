package ch11.integration.withconfig;

import ch11.integration.withconfig.data.Todo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class TodoIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoIntegrationApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(MessageChannel input) {
        return args -> input.send(
                MessageBuilder.withPayload(
                        new Todo("buy milk today", true)).build());
    }
}
