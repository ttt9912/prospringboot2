package app;

import app.producer.TodoProducer;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Pub/Sub pattern: multiple consumers can consume a message
 * - set spring.jms.pub-sub-domain=true
 * - or configure DefaultMessageListenerContainer Bean and dmlc.setPubSubDomain(true);
 *
 * NOTE: very similar to point-to-point app, spring.jms.pub-sub-domain property
 * is the only difference
 *
 * In Memory ActiveMQ Broker
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class PubSubJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PubSubJmsApplication.class, args);
    }

    @Bean
    CommandLineRunner sendTodo(@Value("${todo.jms.destination}") String destination, TodoProducer todoProducer, TodoRepository todoRepository) {
        return args -> todoRepository.findAll().forEach(todo -> todoProducer.send(destination, todo));
    }

}
