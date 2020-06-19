package ch12.cloud.todo.microservice;

import common.todo.data.jpa.todo.Todo;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoMicroserviceApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoMicroserviceApp.class, args);
    }

    @Bean
    CommandLineRunner create() {
        return args -> {
            new Todo("feed me");
            System.out.println();
        };
    }
}
