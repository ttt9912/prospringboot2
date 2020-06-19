package ch9.amqp.fanoutexchange.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrdersRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public OrdersRabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /*
     * - There is no routing key (therefore set to "")
     * - Message will be sent to all queues
     */
    public void sendTo(final String exchange, final String message) {
        rabbitTemplate.convertAndSend(exchange, "", message);
        log.info("OrdersRabbitProducer > message sent to exchange={} message={}", exchange, message);
    }

}
