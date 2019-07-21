package ch10.actuator.custom.endpoints;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * Create custom endpoint
 * ---------------------------------------------------------------------------------
 * - mark class as @Endpoint
 * - mark methods with  @ReadOperation, @WriteOperation or @DeleteOperation *
 *
 * ---------------------------------------------------------------------------------
 * Expose
 * ---------------------------------------------------------------------------------
 * - by default, the endpoint is exposed over JMX
 * - expose via HTTP with management.endpoints.web.exposure.include=*
 *
 * ---------------------------------------------------------------------------------
 * Expose endpoint specifically over JMX or Web only
 * ---------------------------------------------------------------------------------
 * - add @JmxEndpoint or @WebEndpoint
 *
 * ---------------------------------------------------------------------------------
 * Browser
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080/actuator/todostats
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorCustomEndpointsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorCustomEndpointsApplication.class, args);
    }
}
