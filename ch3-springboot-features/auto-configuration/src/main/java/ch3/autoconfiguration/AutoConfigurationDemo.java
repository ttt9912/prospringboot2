package ch3.autoconfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;


/*
 * @SpringBootApplication - @Configuration, @EnableAutoConfiguration, @ComponentScan
 *
 * # see auto configuration report
 *   > spring-boot:run -Dspring-boot.run.arguments=--debug
 *
 * # Disable unnecessary Auto Configurations
 *   @EnableAutoConfiguration(exclude={...}) or
 *   @SpringBootApplication(exclude={...})
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class AutoConfigurationDemo {

    public static void main(String[] args) {
        SpringApplication.run(AutoConfigurationDemo.class, args)
                .close();
    }
}
