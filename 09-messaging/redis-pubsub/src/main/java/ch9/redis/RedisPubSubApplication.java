package ch9.redis;

import ch9.redis.producer.TodoProducer;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Pub/Sub pattern
 *
 * Remote Redis (Docker)
 * - no need to set connection properties
 * - only spring.redis.password must be set if redis docker is not running with -e ALLOW_EMPTY_PASSWORD=yes
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class RedisPubSubApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisPubSubApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendTodos(TodoProducer todoProducer, TodoRepository todoRepository, @Value("${todo.redis.topic}") String topic) {
        return args -> todoRepository.findAll().forEach(
                todo -> todoProducer.sendTo(topic, todo)
        );
    }
}
