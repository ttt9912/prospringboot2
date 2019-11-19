package edurion.datajpa;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaAuditing
@PropertySource("classpath:edurion-data-jpa.properties")
public class EdurionDataJpaConfig {
}
