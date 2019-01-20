package todoclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * non-web application
 *
 * Domain Model: should match the minimum fields of the servers model
 */
@SpringBootApplication
public class TodoClientApp {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TodoClientApp.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
