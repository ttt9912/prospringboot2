package ch9.amqp.headersexchange;

import ch9.amqp.headersexchange.producer.MarketRabbitProducer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * Remote RabbitMQ (Docker)
 *
 * Headers Exchange:
 * - Define named Exchange, Queues, and bind queues to an exchange
 *
 * - no routing key
 * - routes message based on header values instead of routing keys
 * - x-match argument {all, any} in headers binding
 *      all: all the values must match (default)
 *      any: just one matching header value is sufficient
 *
 */
@SpringBootApplication
public class RabbitMqHeadersExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqHeadersExchangeApplication.class, args);
    }

    /*
     * Set ContentType='text/plain' for String message body
     */
    @Bean
    public CommandLineRunner sendMessagesToUS(MarketRabbitProducer producer, @Value("${market.exchange}") String exchange) {
        return args -> {
            Message message = MessageBuilder.withBody("News for US Market".getBytes())
                    .setContentType("text/plain")
                    .setHeader("market-us", "us").build();
            producer.sendTo(exchange, message);
        };
    }

    @Bean
    public CommandLineRunner sendMessagesToEU(MarketRabbitProducer producer, @Value("${market.exchange}") String exchange) {
        return args -> {
            Message message = MessageBuilder.withBody("News for EU Market".getBytes())
                    .setContentType("text/plain")
                    .setHeader("market-eu", "eu").build();
            producer.sendTo(exchange, message);
        };
    }
}
