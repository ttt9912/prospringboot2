package ch9.jms.pointtopoint;

import ch9.jms.pointtopoint.producer.TodoProducer;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Point-to-Point pattern: only one @JmsListener will receive the message
 *
 * In Memory ActiveMQ Broker
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class PointToPointJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PointToPointJmsApplication.class, args);
    }

    @Bean
    CommandLineRunner sendTodo(@Value("${todo.jms.destination}") String destination, TodoProducer todoProducer, TodoRepository todoRepository) {
        return args -> todoRepository.findAll().forEach(todo -> todoProducer.send(destination, todo));
    }
}
