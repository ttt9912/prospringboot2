package ch10.actuator.health.health;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.io.File;

/*
 * Health status
 * - UP             - HTTP 200
 * - DOWN           - HTTP 200
 * - OUT_OF_SERVICE - HTTP 503
 * - UNKNOWN        - HTTP 503
 */
@Component
public class TodoHealthCheck implements HealthIndicator {
    private final String path;

    public TodoHealthCheck(@Value("${todo.path}") String path) {
        this.path = path;
    }

    @Override
    public Health health() {
        final File file = new File(path);

        if (!file.exists()) {
            return Health.outOfService().build();
        }

        if (!file.canWrite()) {
            Health.down().build();
        }

        if (file.isFile()) {
            return Health.unknown().build();
        }

        return Health.up().build();
    }
}
