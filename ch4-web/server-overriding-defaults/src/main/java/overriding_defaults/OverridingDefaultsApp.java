package overriding_defaults;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * application.yml
 */
@SpringBootApplication
public class OverridingDefaultsApp {
    public static void main(String[] args) {
        SpringApplication.run(OverridingDefaultsApp.class, args);
    }
}
