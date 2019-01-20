package overriding_defaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * -----------------------------------------------------------------------------
 * Demo Features
 * -----------------------------------------------------------------------------
 * - manage a session
 * - enable HTTP2
 *
 * -----------------------------------------------------------------------------
 * Json Date Format
 * -----------------------------------------------------------------------------
 * - Date          -> application.yml
 * - LocalDateTime -> @JsonFormat
 *
 * -----------------------------------------------------------------------------
 * Content Type json/xml
 * -----------------------------------------------------------------------------
 * HttpMessageConverters negotiate content, default is json
 *
 * # ?format parameter
 * - fasterxml dependency
 * - favor-parameter property
 * http://localhost:8080/my-app/api/todos?format=xml
 *
 * -----------------------------------------------------------------------------
 * Different Application Container (Jetty)
 * -----------------------------------------------------------------------------
 * - pom
 */
@SpringBootApplication
public class OverridingDefaultsApp {
    public static void main(String[] args) {
        SpringApplication.run(OverridingDefaultsApp.class, args);
    }
}
