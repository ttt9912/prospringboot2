package jdbcapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class JdbcApp {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class, args);
    }

    @Bean
    CommandLineRunner showBeans(ApplicationContext context) {
        return args -> {
            System.out.println("Beans of Type @Component - " + context.getBeansWithAnnotation(Component.class));
            System.out.println("Beans of Type @RestController - " + context.getBeansWithAnnotation(RestController.class));
            System.out.println("Beans of Type @Repository - " + context.getBeansWithAnnotation(Repository.class));
        };
    }
}
