package metrics;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * Micrometer
 * ---------------------------------------------------------------------------------
 * - write monitoring code once and use any other third party monitoring system
 * - Spring Boot Actuator offers basic metrics and integration
 *   and auto-configuration with Micrometer
 *
 * ---------------------------------------------------------------------------------
 * Custom Metrics using Micrometer
 * ---------------------------------------------------------------------------------
 * - use MeterRegistry to submit metrics
 *
 * ---------------------------------------------------------------------------------
 * Auto Configuration for export to Monitoring Systems
 * ---------------------------------------------------------------------------------
 * - Spring Boot Actuator auto-configures and registers every Micrometer registry
 *   based on dependencies (JMX and Prometheus)
 *
 * - for Prometheus, the actuator configures the /actuator/prometheus endpoint
 *
 * ---------------------------------------------------------------------------------
 * Run
 * ---------------------------------------------------------------------------------
 * - docker-compose up
 * - management.endpoints.web.exposure.include=*
 * - start app
 * - Prometheus setup, connect to actuator (prometheus.yml)
 * - Grafana Setup (connect to Prometheus)
 *
 * - Prometheus: http://localhost:9090/targets
 * - Grafana: http://localhost:3000
 *      (admin/admin)
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class TodoActuatorMetricsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoActuatorMetricsApplication.class, args);
    }
}
