package ch9.amqp.headersexchange.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MarketRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    public MarketRabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /*
     * - There is no routing key (therefore set to "")
     * - Message will be routed by its header
     */
    public void sendTo(final String exchange, final Message message) {
        rabbitTemplate.convertAndSend(exchange, "", message);
        log.info("MarketRabbitProducer > message sent to exchange={} headers={} message={}",
                exchange, message.getMessageProperties().getHeaders(), new String(message.getBody()));
    }

}
