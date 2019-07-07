package app.consumer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * Default Exchange: only one @RabbitListener will receive the message
 */
@Slf4j
@Component
public class TodoRabbitConsumer {

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processTodo(Todo todo) {
        log.info("TodoConsumer > received Todo {}", todo);
    }

    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processTodo2(Todo todo) {
        log.info("TodoConsumer2 > received Todo {}", todo);
    }
}
