package ch9.amqp.directexchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public DirectExchange shoppingExchange(@Value("${shopping.exchange}") String exchange) {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding invoiceBinding(Queue invoiceQueue, DirectExchange shoppingExchange, @Value("${shop.invoice.routingkey}") String routingKey) {
        return BindingBuilder.bind(invoiceQueue).to(shoppingExchange).with(routingKey);
    }

    @Bean
    public Binding deliveryBinding(Queue deliveryQueue, DirectExchange shoppingExchange, @Value("${shop.delivery.routingkey}") String routingKey) {
        return BindingBuilder.bind(deliveryQueue).to(shoppingExchange).with(routingKey);
    }

    @Bean
    public Queue invoiceQueue(@Value("${shop.invoice.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    @Bean
    public Queue deliveryQueue(@Value("${shop.delivery.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }


    /*
     * spring MessageConverter with support for LocalDateTime etc.
     * (Used by producer and Consumer)
     */
    @Bean
    public MessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter(objectMapper());
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}
