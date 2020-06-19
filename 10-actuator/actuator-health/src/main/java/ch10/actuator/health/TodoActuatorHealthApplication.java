package ch10.actuator.health;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * Include other systems (like DB)
 * ---------------------------------------------------------------------------------
 * management.endpoint.health.show-details=<...>
 * - never (default)
 * - when-autorized (configure roles with management.endpoint.health.roles)
 * - always
 *
 * ---------------------------------------------------------------------------------
 * Spring Boot Actuator HealthIndicator
 * ---------------------------------------------------------------------------------
 * - collects all information about the system
 * - returns a Health instance containing all information
 *
 * ---------------------------------------------------------------------------------
 * Auto Configuration
 * ---------------------------------------------------------------------------------
 * - health indicators are auto configured based on the classpath
 * - Examples: DiskSpaceHealthIndicator, RedisHealthIndicator,
 *             DataSourceHealthIndicator, etc.
 *
 * ---------------------------------------------------------------------------------
 * Custom HealthIndicator
 * ---------------------------------------------------------------------------------
 * - create bean implementing HealthIndicator interface
 * - return a Health instance
 *
 * - try it: /actuator/health
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorHealthApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorHealthApplication.class, args);
    }
}
