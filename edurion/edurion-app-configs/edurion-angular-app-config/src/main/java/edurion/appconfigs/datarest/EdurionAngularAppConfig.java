package edurion.appconfigs.datarest;

import edurion.business.edutask.EdutaskService;
import edurion.datajpa.EdurionDataJpaConfig;
import edurion.datajpa.edutask.EdutaskRepositoryImpl;
import edurion.service.EdurionServiceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//@EnableAutoConfiguration
@Import({EdurionDataJpaConfig.class, EdurionServiceConfig.class})
public class EdurionAngularAppConfig {

    @Bean
    public EdutaskService edutaskService(EdutaskRepositoryImpl edutaskRepository) {
        return new EdutaskService(edutaskRepository);
    }

}