package ch10.actuator.basics;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorApplication.class, args);
    }
}
