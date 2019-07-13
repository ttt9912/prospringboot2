package ch9.amqp.headersexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * - No Routing Key
 * - Binding: define, what header keys of a message must match so that the message will
 *   be sent to a queue (whereAll() vs. whereAny())
 */
@Configuration
public class Config {

    @Bean
    public HeadersExchange marketExchange(@Value("${market.exchange}") String exchange) {
        return new HeadersExchange(exchange);
    }

    @Bean
    public Binding usBinding(Queue usQueue, HeadersExchange marketExchange) {
        return BindingBuilder.bind(usQueue).to(marketExchange)
                .whereAll("market-us").exist();
    }

    @Bean
    public Binding euBinding(Queue euQueue, HeadersExchange marketExchange) {
        return BindingBuilder.bind(euQueue).to(marketExchange)
                .whereAll("market-eu").exist();
    }

    @Bean
    public Binding allBinding(Queue allQueue, HeadersExchange marketExchange) {
        return BindingBuilder.bind(allQueue).to(marketExchange)
                .whereAny("market-us", "market-eu").exist();
    }

    @Bean
    public Queue usQueue(@Value("${market.us.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    @Bean
    public Queue euQueue(@Value("${market.eu.queue}") String queue) {
        return new Queue(queue, true, false, false);
    }

    @Bean
    public Queue allQueue(@Value("${market.all.queue}") String queue) {
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
