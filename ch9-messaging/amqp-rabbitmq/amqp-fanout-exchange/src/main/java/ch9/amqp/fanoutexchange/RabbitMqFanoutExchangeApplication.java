package ch9.amqp.fanoutexchange;

import ch9.amqp.fanoutexchange.producer.OrdersRabbitProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * Remote RabbitMQ (Docker)
 *
 * Fanout Exchange:
 * - Define named Exchange, Queues, and bind queues to an exchange
 *
 * - no routing key
 * - dispatches a message to ALL the binded queues without taking care of the routing key
 * - topic like behaviour
 */
@SpringBootApplication
public class RabbitMqFanoutExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqFanoutExchangeApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendInventory(OrdersRabbitProducer producer, @Value("${orders.exchange}") String exchange) {
        return args -> {
            producer.sendTo(exchange, "Inventory=30");
        };
    }

    @Bean
    public CommandLineRunner sendInvoice(OrdersRabbitProducer producer, @Value("${orders.exchange}") String exchange) {
        return args -> {
            producer.sendTo(exchange, "amount=100");
        };
    }

    @Bean
    public CommandLineRunner sendDelivery(OrdersRabbitProducer producer, @Value("${orders.exchange}") String exchange) {
        return args -> {
            producer.sendTo(exchange, "will arrive in 2 days");
        };
    }
}
