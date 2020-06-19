package ch9.amqp.headersexchange.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * Headers Exchange:
 * - only one @RabbitListener will receive the message
 * - BUT: message can be sent to multiple queues
 */
@Slf4j
@Component
public class MarketRabbitConsumer {

    @RabbitListener(queues = "${market.us.queue}")
    public void processUSMessage(Message message) {
        log.info("Consumer Queue[market.us.queue] > received message headers={} body='{}'",
                message.getMessageProperties().getHeaders(), new String(message.getBody()));
    }

    @RabbitListener(queues = "${market.eu.queue}")
    public void processEUMessage(Message message) {
        log.info("Consumer Queue[market.eu.queue] > received message headers={} body='{}'",
                message.getMessageProperties().getHeaders(), new String(message.getBody()));
    }

    @RabbitListener(queues = "${market.all.queue}")
    public void processAllMessage(Message message) {
        log.info("Consumer Queue[market.all.queue] > received message headers={} body='{}'",
                message.getMessageProperties().getHeaders(), new String(message.getBody()));
    }

    @RabbitListener(queues = "${market.all.queue}")
    public void processAllMessage2(Message message) {
        log.info("Consumer2 Queue[market.all.queue] > received message headers={} body='{}'",
                message.getMessageProperties().getHeaders(), new String(message.getBody()));
    }

}
