package ch9.amqp.fanoutexchange.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * Fanout Exchange:
 * - message is sent to every queue
 * - only one @RabbitListener will receive a specific message
 * - message is deleted from queue after read
 */
@Slf4j
@Component
public class OrdersRabbitConsumer {

    @RabbitListener(queues = "${inventory.queue}")
    public void processInventoryMessage(String message) {
        log.info("Consumer Queue[inventory.queue] > received message='{}'", message);
    }

    @RabbitListener(queues = "${invoice.queue}")
    public void processInvoiceMessage(String message) {
        log.info("Consumer Queue[invoice.queue] > received message='{}'", message);
    }

    @RabbitListener(queues = "${delivery.queue}")
    public void processDeliveryMessage(String message) {
        log.info("Consumer Queue[delivery.queue] > received message='{}'", message);
    }

    @RabbitListener(queues = "${delivery.queue}")
    public void processDeliveryMessage2(String message) {
        log.info("Consumer2 Queue[delivery.queue] > received message='{}'", message);
    }

}
