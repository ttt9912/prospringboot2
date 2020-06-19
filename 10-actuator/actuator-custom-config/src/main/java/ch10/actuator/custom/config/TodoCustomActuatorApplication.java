package ch10.actuator.custom.config;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * change management context path
 * ---------------------------------------------------------------------------------
 * management.endpoints.web.base-path=/monitor
 *
 * ---------------------------------------------------------------------------------
 * change endpoint name
 * ---------------------------------------------------------------------------------
 * management.endpoints.web.path-mapping.<endpoint-name>=<new-name>
 *
 * ---------------------------------------------------------------------------------
 * other management.server.* properties
 * ---------------------------------------------------------------------------------
 * - change server address
 * - add ssl
 * - use particular IP
 * - change port
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * /actuator is now running under:
 * http://127.0.0.1:8081/admin/monitor
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoCustomActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoCustomActuatorApplication.class, args);
    }
}
