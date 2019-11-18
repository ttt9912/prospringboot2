package jasypt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JasyptApp {

    public static void main(final String[] args) {
        SpringApplication.run(JasyptApp.class, args);
    }

    @Value("${user.password}")
    private String password;

    @Bean
    CommandLineRunner run() {
        return args -> {
            System.out.println("password: " + password);
        };
    }
}
