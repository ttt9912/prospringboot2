package ch7.data.jpa.tests;

import common.todo.data.jpa.CommonTodoDataJpaConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Import(CommonTodoDataJpaConfig.class)
public class DataJpaApp {
    public static void main(String[] args) {
        SpringApplication.run(DataJpaApp.class, args);
    }

    @Bean
    CommandLineRunner showBeans(ApplicationContext context) {
        return args -> {
            System.out.println("Beans of Type @Component - " + context.getBeansWithAnnotation(Component.class));
            System.out.println("Beans of Type @RestController - " + context.getBeansWithAnnotation(RestController.class));
            System.out.println("Beans of Type @Repository - " + context.getBeansWithAnnotation(Repository.class));
            System.out.println("Beans of Type CrudRepository - " + context.getBeansOfType(CrudRepository.class));
        };
    }

}
