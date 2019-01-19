package config_properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

/*
 * ---------------------------------------------------------------------------------------------------
 * # Provide Spring Boot Configuration Properties (with precedence, non complete list)
 * ---------------------------------------------------------------------------------------------------
 * # via Command Line Arguments
 * - Program Arguments: --data.server=remote:4040
 * > mvn spring-boot:run -Dspring-boot.run.arguments="--data.server=remote:4040"
 * > mvn spring-boot:run -Ddata.server=remote:4040
 * > java -jar app-properties-0.0.1-SNAPSHOT.jar --data.server=remote:4040
 *
 *
 * # via environment variable
 * > DATA_SERVER=5050 java -jar app-properties-0.0.1-SNAPSHOT.jar
 * > SPRING_APPLICATION_JSON='{"data":{"server":"5050"}}' java -jar app-properties-0.0.1-SNAPSHOT.jar
 *
 * # application.properties, application.yml
 * - data.server=remoteserver:3030
 * ---------------------------------------------------------------------------------------------------
 * # Common application properties
 *   https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
 *
 * # Accessing Properties
 * - @Value
 * - Environment (extents PropertyResolver)
 *
 * # Change Name & Location of Properties files
 * - use spring.config.name and spring.config.location properties
 * > mvn spring-boot:run -Dspring.config.name=mycfg -Dspring.config.location=classpath:app/
 * > java -jar properties-0.0.1-SNAPSHOT.jar --spring.config.name=mycfg --spring.config.location=classpath:app/
 * > SPRING_CONFIG_NAME=mycfg SPRING_CONFIG_LOCATION=classpath:app/ java -jar properties-0.0.1-SNAPSHOT.jar
 *
 */
@SpringBootApplication
public class PropertiesDemo {
    private static final Logger log = LoggerFactory.getLogger(PropertiesDemo.class);

    public static void main(String[] args) {
        SpringApplication.run(PropertiesDemo.class, args)
                .close();
    }

    /*
     * Accessing Properties via @Value
     */
    @Value("${data.server}")
    private String server;

    @Bean
    CommandLineRunner runner() {
        return args -> log.info("# @Value('${data.server}') = {}", server);
    }

    /*
     * Accessing Properties via Environment
     */
    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner runner2() {
        return args -> log.info("# Environment property = {}",
                environment.getProperty("data.server"));
    }
}
