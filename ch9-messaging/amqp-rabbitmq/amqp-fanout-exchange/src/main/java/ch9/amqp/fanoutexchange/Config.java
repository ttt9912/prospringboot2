package ch9.amqp.fanoutexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * - No Routing Key
 * - Messages will be sent to all queues
 */
@Configuration
public class Config {

    @Bean
    public FanoutExchange ordersExchange(@Value("${orders.exchange}") String exchange) {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Binding inventoryBinding(Queue inventoryQueue, FanoutExchange ordersExchange) {
        return BindingBuilder.bind(inventoryQueue).to(ordersExchange);
    }

    @Bean
    public Binding invoiceBinding(Queue invoiceQueue, FanoutExchange ordersExchange) {
        return BindingBuilder.bind(invoiceQueue).to(ordersExchange);
    }

    @Bean
    public Binding deliveryBinding(Queue deliveryQueue, FanoutExchange ordersExchange) {
        return BindingBuilder.bind(deliveryQueue).to(ordersExchange);
    }

    @Bean
    public Queue inventoryQueue(@Value("${inventory.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    @Bean
    public Queue invoiceQueue(@Value("${invoice.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    @Bean
    public Queue deliveryQueue(@Value("${delivery.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    /*
     * spring MessageConverter
     *
     * - No need to use Jackson2JsonMessageConverter, since messages are strings only
     */
    @Bean
    public MessageConverter simpleMessageConverter() {
        return new SimpleMessageConverter();
    }
}
