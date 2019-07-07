package ch3.properties.profilebased;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import java.util.Arrays;

/*
 * Create custom Properties and Beans based on Profiles
 * - allows separate environments without repackage
 *
 * # specity active Profile
 * - @ActiveProfile("dev")
 * - Environment.setActiveProfiles()
 * - SPRING_PROFILES_ACTIVE environment variable
 * - spring.profiles.active property
 *
 * # without active Profile
 *   spring uses the default - grabs application.properties
 *
 * # Profile based Property files
 *   application-{profile}.properties
 *   application-{profile}.yml
 */
@SpringBootApplication
public class ProfileBasedDemo {
    private static final Logger log = LoggerFactory.getLogger(ProfileBasedDemo.class);

    // > mvn spring-boot:run -Dspring.profiles.active=prod
    public static void main(String[] args) {
        SpringApplication.run(ProfileBasedDemo.class, args)
                .close();
    }

    @Autowired
    private Environment env;

    @Bean
    CommandLineRunner runner() {
        return args -> {
            log.info("# active profiles={}", Arrays.asList(env.getActiveProfiles()));
            log.info("# server.ip={}", env.getProperty("server.ip"));
        };
    }
}
