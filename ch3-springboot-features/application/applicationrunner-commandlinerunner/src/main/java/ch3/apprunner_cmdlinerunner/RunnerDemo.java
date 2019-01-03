package ch3.apprunner_cmdlinerunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

/*
 * # ApplicationRunner & CommandLineRunner
 * - expose a run() method which execute after SpringApplication
 * - have acces to beans
 *
 */
@SpringBootApplication
public class RunnerDemo implements ApplicationRunner, CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RunnerDemo.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerDemo.class)
                .close();
    }

    @Bean
    String name() {
        return "simple String bean";
    }

    @Autowired
    String name;

    // ApplicationRunner
    @Override
    public void run(final ApplicationArguments args) throws Exception {
        log.info("# ApplicationRunner > {}", name);
    }

    // CommandLineRunner
    @Override
    public void run(final String... args) throws Exception {
        log.info("# CommandLineRunner > {}", name);
    }

    // run as beans
    @Bean
    @Order(1)
    CommandLineRunner commandLineRunnerA() {
        return args -> log.info("# commandLineRunnerA > {}", name);
    }

    @Bean
    @Order(2)
    CommandLineRunner commandLineRunnerB() {
        return args -> log.info("# commandLineRunnerB > {}", name);
    }

    @Bean
    ApplicationRunner applicationRunnerA() {
        return args -> log.info("# applicationRunnerA > {}", name);
    }
}
