package ch9.amqp.directexchange.producer;

import ch9.amqp.directexchange.data.Delivery;
import ch9.amqp.directexchange.data.Invoice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShoppingRabbitProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${shopping.exchange}")
    private String shoppingExchange;

    @Value("${shop.delivery.routingkey}")
    private String deliveryRoutingKey;

    @Value("${shop.invoice.routingkey}")
    private String invoiceRoutingKey;

    public ShoppingRabbitProducer(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendDelivery(final Delivery delivery) {
        rabbitTemplate.convertAndSend(shoppingExchange, deliveryRoutingKey, delivery);
        log.info("ShoppingRabbitProducer > delivery sent {}", delivery);
    }

    public void sendInvoice(final Invoice invoice) {
        rabbitTemplate.convertAndSend(shoppingExchange, invoiceRoutingKey, invoice);
        log.info("ShoppingRabbitProducer > invoice sent {}", invoice);
    }

}
