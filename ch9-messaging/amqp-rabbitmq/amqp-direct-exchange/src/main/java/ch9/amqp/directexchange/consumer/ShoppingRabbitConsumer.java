package ch9.amqp.directexchange.consumer;

import ch9.amqp.directexchange.data.Delivery;
import ch9.amqp.directexchange.data.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/*
 * Direct Exchange:
 * - only one @RabbitListener will receive the message
 */
@Slf4j
@Component
public class ShoppingRabbitConsumer {

    @RabbitListener(queues = "${shop.delivery.queue}")
    public void processDelivery(Delivery delivery) {
        log.info("ShoppingRabbitConsumer > received delivery {}", delivery);
    }

    @RabbitListener(queues = "${shop.invoice.queue}")
    public void processInvoice(Invoice invoice) {
        log.info("ShoppingRabbitConsumer > received invoice {}", invoice);
    }

    @RabbitListener(queues = "${shop.invoice.queue}")
    public void processInvoice2(Invoice invoice) {
        log.info("ShoppingRabbitConsumer > received invoice2 {}", invoice);
    }

}
