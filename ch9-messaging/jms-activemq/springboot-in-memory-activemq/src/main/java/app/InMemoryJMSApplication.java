package app;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * Point-to-Point pattern with JMS
 *
 * In Memory ActiveMQ Broker
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class InMemoryJMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(InMemoryJMSApplication.class, args);
    }
}
