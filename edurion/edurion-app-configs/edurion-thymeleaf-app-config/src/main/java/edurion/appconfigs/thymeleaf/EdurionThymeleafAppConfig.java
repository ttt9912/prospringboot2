package edurion.appconfigs.thymeleaf;

import edurion.business.edutask.EdutaskService;
import edurion.datajpa.EdurionDataJpaConfig;
import edurion.datajpa.edutask.EdutaskRepositoryImpl;
import edurion.uithymeleaf.EdurionUiThymeleafConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EdurionDataJpaConfig.class, EdurionUiThymeleafConfig.class})
public class EdurionThymeleafAppConfig {

    @Bean
    public EdutaskService edutaskService(EdutaskRepositoryImpl edutaskRepository) {
        return new EdutaskService(edutaskRepository);
    }

}
