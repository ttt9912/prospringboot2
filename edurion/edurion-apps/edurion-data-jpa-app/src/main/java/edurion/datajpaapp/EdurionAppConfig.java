package edurion.datajpaapp;

import edurion.business.edutask.EdutaskService;
import edurion.datajpa.EdurionDataJpaConfig;
import edurion.datajpa.edutask.EdutaskRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EdurionDataJpaConfig.class)
public class EdurionAppConfig {

    @Bean
    public EdutaskService edutaskService(EdutaskRepositoryImpl edutaskRepository) {
        return new EdutaskService(edutaskRepository);
    }
}
