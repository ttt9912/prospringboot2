package ch9.amqp.topicexchange.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MarketRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public MarketRabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTo(final String exchange, final String routingKey, final String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        log.info("MarketRabbitProducer > message sent to exchange={} routingKey={} message={}",
                exchange, routingKey, message);
    }

}
