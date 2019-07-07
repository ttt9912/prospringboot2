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
 * Default Exchange: only one @RabbitListener will receive the message
 *
 * ---------------------------------------------------------------------------------
 * build container
 * ---------------------------------------------------------------------------------
 * docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
 *
 * NOTE: RabbitMQ stores data based on what it calls the "Node Name", which defaults
 * to the hostname. Specify --hostname explicitly for each daemon so that we don't
 * get a random hostname and can keep track of our data.
 *
 * ---------------------------------------------------------------------------------
 * rerun
 * ---------------------------------------------------------------------------------
 * docker start some-rabbit
 *
 * ---------------------------------------------------------------------------------
 * Admin Console
 * ---------------------------------------------------------------------------------
 * localhost:15672
 * login: guest/guest
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class RabbitMqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendTodos(@Value("${todo.amqp.queue}") String destination, TodoRabbitProducer producer, TodoRepository repository) {
        return args -> repository.findAll().forEach(
                todo -> producer.sendTo(destination, todo));
    }

}
