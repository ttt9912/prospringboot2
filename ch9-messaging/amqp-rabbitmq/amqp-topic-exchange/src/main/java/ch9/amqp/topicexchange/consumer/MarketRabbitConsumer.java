package ch9.amqp.topicexchange.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * Topic Exchange:
 * - only one @RabbitListener will receive the message
 * - BUT: message can be sent to multiple queues
 */
@Slf4j
@Component
public class MarketRabbitConsumer {

    @RabbitListener(queues = "${market.us.queue}")
    public void processUSMessage(String message) {
        log.info("Consumer Queue[market.us.queue] > received message '{}'", message);
    }

    @RabbitListener(queues = "${market.eu.queue}")
    public void processEUMessage(String message) {
        log.info("Consumer Queue[market.eu.queue] > received message '{}'", message);
    }

    @RabbitListener(queues = "${market.all.queue}")
    public void processAllMessage(String message) {
        log.info("Consumer Queue[market.all.queue] > received message '{}'", message);
    }

    @RabbitListener(queues = "${market.all.queue}")
    public void processAllMessage2(String message) {
        log.info("Consumer2 Queue[market.all.queue] > received message '{}'", message);
    }

}
