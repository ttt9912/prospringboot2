package ch8.authprovider.inmemory;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class InMemoryAuthApp {

    public static void main(String[] args) {
        SpringApplication.run(InMemoryAuthApp.class, args);
    }

}

