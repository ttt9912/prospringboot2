package ch10.actuator.health;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorHealthApplication.class, args);
    }
}
