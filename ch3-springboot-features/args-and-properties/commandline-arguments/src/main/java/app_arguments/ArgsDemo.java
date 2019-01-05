package app_arguments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*
 * Beans have access to args
 * - args must be provided to the run() method
 *
 * # Provide args to mvn spring-boot:run command
 *   mvn spring-boot:run -Dspring-boot.run.arguments="--enable"
 *   mvn spring-boot:run -Dspring-boot.run.arguments="arg1,arg2"
 *
 * # Provide args to run config
 *   Program Arguments: --enable
 *
 * # Provide args to JAR
 *   java -jar app-arguments-0.0.1-SNAPSHOT.jar --enable arg1 arg2
 *
 *
 * # Override System Properties
 *   spring-boot:run -Dspring-boot.run.arguments=--server.port=8085
 *
 * # Note - maven arg. vs spring boot arg
 *   mvn spring-boot:run --debug                                -> maven in debug mode
 *   mvn spring-boot:run -Dspring-boot.run.arguments=--debug    -> springboot in debug mode
 */
@SpringBootApplication
public class ArgsDemo {
    private static final Logger log = LoggerFactory.getLogger(ArgsDemo.class);

    public static void main(String[] args) {
        log.info("# main args: {}", Arrays.asList(args));

        SpringApplication.run(ArgsDemo.class, args).close();
    }

    @Bean
    CommandLineRunner runner() {
        return args -> log.info("# args: {}", Arrays.asList(args));
    }
}

@Component
class DemoComponent {
    private static final Logger log = LoggerFactory.getLogger(DemoComponent.class);

    public DemoComponent(ApplicationArguments args) {
        log.info("# enabled set: {}", args.containsOption("enable"));

        log.info("# ApplicationArguments - OptionNames: {}, NonOptionArgs: {}, SourceArgs: {}",
                args.getOptionNames(),
                args.getNonOptionArgs(),
                Arrays.asList(args.getSourceArgs()));
    }
}


