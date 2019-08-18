package common.todo.webapp;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoApp {
    public static void main(String args[]) {
        SpringApplication.run(TodoApp.class);
    }
}
