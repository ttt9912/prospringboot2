package ch9.amqp.topicexchange;

import ch9.amqp.topicexchange.producer.MarketRabbitProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * Remote RabbitMQ (Docker)
 *
 * Topic Exchange:
 * - Define named Exchange, Queues, and bind queues to an exchange
 * - allows # and * in the binding key
 *    * substitutes exactly one word
 *    # substitutes zero or more words
 * - message is sent to one or more queues
 *
 */
@SpringBootApplication
public class RabbitMqTopicExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqTopicExchangeApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendMessagesToUS(MarketRabbitProducer producer, @Value("${market.exchange}") String exchange, @Value("${market.us.routingkey}") String routingKey) {
        return args -> {
            producer.sendTo(exchange, routingKey, "News for US Market");
        };
    }

    @Bean
    public CommandLineRunner sendMessagesToEU(MarketRabbitProducer producer, @Value("${market.exchange}") String exchange, @Value("${market.eu.routingkey}") String routingKey) {
        return args -> {
            producer.sendTo(exchange, routingKey, "News for EU Market");
        };
    }

}
