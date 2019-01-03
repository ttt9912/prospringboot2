package ch3.properties_profiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Create custom Properties and Beans based on Profiles
 * - allows separate environments without repackage
 *
 * # specity active Profile
 * - @ActiveProfile("dev")
 * - Environment.setActiveProfiles()
 * - SPRING_PROFILES_ACTIVE environment variable
 * - pring.profiles.active property
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

    public static void main(String[] args) {
        SpringApplication.run(ProfileBasedDemo.class, args)
                .close();
    }
}
