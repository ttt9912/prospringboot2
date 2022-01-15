package ch7.data.jpa.tests;

import common.todo.data.jpa.CommonTodoDataJpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * http://localhost:8080/h2-console
 */
@SpringBootApplication
@Import(CommonTodoDataJpaConfig.class)
public class DataJpaApp {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApp.class, args);
    }

}
