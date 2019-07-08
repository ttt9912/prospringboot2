package ch9.amqp.defaultexchange;

import ch9.amqp.defaultexchange.producer.TodoRabbitProducer;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Remote RabbitMQ (Docker)
 *
 * Default Exchange:
 * - only one @RabbitListener will receive the message
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class RabbitMqDefaultExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqDefaultExchangeApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendTodos(@Value("${todo.amqp.queue}") String destination, TodoRabbitProducer producer, TodoRepository repository) {
        return args -> repository.findAll().forEach(
                todo -> producer.sendTo(destination, todo));
    }

}
