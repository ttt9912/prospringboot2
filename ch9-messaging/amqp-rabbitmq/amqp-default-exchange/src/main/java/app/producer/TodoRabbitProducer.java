package app.producer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoRabbitProducer {

    private final RabbitTemplate rabbitTemplate;

    public TodoRabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /*
     * routingKey: queue name
     *
     * message is sent to the exchange (default exchange), which
     * routes it to the right queue
     */
    public void sendTo(String routingKey, Todo todo) {
        rabbitTemplate.convertAndSend(routingKey, todo);
        log.info("TodoProducer > message sent {}", todo);
    }
}
