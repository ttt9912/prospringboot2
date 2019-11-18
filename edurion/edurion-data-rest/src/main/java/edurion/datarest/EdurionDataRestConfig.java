package edurion.datarest;

import edurion.datajpa.EdurionDataJpaConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(EdurionDataJpaConfig.class)
@PropertySource("classpath:edurion-data-rest.properties")
public class EdurionDataRestConfig {
}
