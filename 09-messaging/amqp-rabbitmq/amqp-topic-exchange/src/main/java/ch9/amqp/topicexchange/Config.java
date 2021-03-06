package ch9.amqp.topicexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public TopicExchange marketExchange(@Value("${market.exchange}") String exchange) {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding usBinding(Queue usQueue, TopicExchange marketExchange, @Value("${market.us.routingkey}") String routingKey) {
        return BindingBuilder.bind(usQueue).to(marketExchange).with(routingKey);
    }

    @Bean
    public Binding euBinding(Queue euQueue, TopicExchange marketExchange, @Value("${market.eu.routingkey}") String routingKey) {
        return BindingBuilder.bind(euQueue).to(marketExchange).with(routingKey);
    }

    @Bean
    public Binding allBinding(Queue allQueue, TopicExchange marketExchange, @Value("${market.all.routingkey}") String routingKey) {
        return BindingBuilder.bind(allQueue).to(marketExchange).with(routingKey);
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
