package ch9.amqp.directexchange;

import ch9.amqp.directexchange.data.Delivery;
import ch9.amqp.directexchange.data.Invoice;
import ch9.amqp.directexchange.producer.ShoppingRabbitProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/*
 * Remote RabbitMQ (Docker)
 *
 * Direct Exchange:
 * - Define named Exchange, Queues, and bind queues to an exchange
 *
 *
 */
@SpringBootApplication
public class RabbitMqDirectExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqDirectExchangeApplication.class, args);
    }

    @Bean
    public CommandLineRunner sendDeliveries(ShoppingRabbitProducer producer) {
        return args -> {
            producer.sendDelivery(new Delivery(LocalDate.of(2019, 11, 4)));
            producer.sendDelivery(new Delivery(LocalDate.of(2019, 5, 5)));
        };
    }

    @Bean
    public CommandLineRunner sendInvoices(ShoppingRabbitProducer producer) {
        return args -> {
            producer.sendInvoice(new Invoice(100));
            producer.sendInvoice(new Invoice(500));
        };
    }

}
