package edurion.apps.datarest;

import edurion.appconfigs.datarest.EdurionDataRestAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(EdurionDataRestAppConfig.class)
public class EdurionDataRestApp {

    public static void main(String[] args) {
        SpringApplication.run(EdurionDataRestApp.class, args);
    }
}
