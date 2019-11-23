package edurion.apps.thymeleaf;

import edurion.appconfigs.thymeleaf.EdurionThymeleafAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EdurionThymeleafAppConfig.class)
public class EdurionThymeleafApp {

    public static void main(String[] args) {
        SpringApplication.run(EdurionThymeleafApp.class, args);
    }
}
