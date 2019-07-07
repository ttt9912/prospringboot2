package ch9.jms.remote.activemq;

import ch9.jms.remote.activemq.producer.TodoProducer;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Remote ActiveMQ Broker (Docker)
 *
 * NOTE: same as point-to-point app, only difference is
 * the connection info in application.properties
 *
 * ---------------------------------------------------------------------------------
 * run
 * ---------------------------------------------------------------------------------
 * docker run -p 61616:61616 -p 8161:8161 -t webcenter/activemq
 *
 * ---------------------------------------------------------------------------------
 * Admin Console
 * ---------------------------------------------------------------------------------
 * localhost:8161/admin/
 * login: admin/admin
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class RemoteJmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteJmsApplication.class, args);
    }

    @Bean
    CommandLineRunner sendTodo(@Value("${todo.jms.destination}") String destination, TodoProducer todoProducer, TodoRepository todoRepository) {
        return args -> todoRepository.findAll().forEach(todo -> todoProducer.send(destination, todo));
    }

}
