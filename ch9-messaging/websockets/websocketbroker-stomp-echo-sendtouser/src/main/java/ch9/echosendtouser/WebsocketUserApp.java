package ch9.echosendtouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Convention: send to /queue/ instead of /topic/ for targeting a single user
 *
 * Go to localhost:8080
 *
 * Users
 * - Paul:123
 * - Peter:123
 *
 * Test Multiple Sessions per user:
 * - open app in multiple tabs or
 * - login from different browsers with same user
 */
@SpringBootApplication
public class WebsocketUserApp {
    public static void main(String[] args) {
        SpringApplication.run(WebsocketUserApp.class, args);
    }
}
