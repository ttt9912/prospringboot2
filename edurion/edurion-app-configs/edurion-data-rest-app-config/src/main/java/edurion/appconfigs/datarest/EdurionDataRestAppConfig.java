package edurion.appconfigs.datarest;

import edurion.business.edutask.EdutaskService;
import edurion.datajpa.edutask.EdutaskRepositoryImpl;
import edurion.datarest.EdurionDataRestConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EdurionDataRestConfig.class)
public class EdurionDataRestAppConfig {

    @Bean
    public EdutaskService edutaskService(EdutaskRepositoryImpl edutaskRepository) {
        return new EdutaskService(edutaskRepository);
    }

}
