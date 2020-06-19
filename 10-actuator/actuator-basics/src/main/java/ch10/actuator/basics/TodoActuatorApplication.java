package ch10.actuator.basics;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * Web default exposed endpoints
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080/actuator/health
 * - http://localhost:8080/actuator/info
 *
 * ---------------------------------------------------------------------------------
 * Expose all web endpoints
 * ---------------------------------------------------------------------------------
 * management.endpoints.web.exposure.include=*
 *
 * ---------------------------------------------------------------------------------
 * Enable/disable specific endpoint
 * ---------------------------------------------------------------------------------
 * management.endpoint.<ENDPOINT-NAME>.enabled
 * -> management.endpoint.shutdown.enabled=true
 *
 * ---------------------------------------------------------------------------------
 * Show exposed Enpoints
 * ---------------------------------------------------------------------------------
 * http://localhost:8080/actuator
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorApplication.class, args);
    }
}
