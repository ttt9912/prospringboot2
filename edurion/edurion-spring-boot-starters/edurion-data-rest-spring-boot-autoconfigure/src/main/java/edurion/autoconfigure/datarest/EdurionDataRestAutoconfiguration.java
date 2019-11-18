package edurion.autoconfigure.datarest;

import edurion.business.edutask.EdutaskRepository;
import edurion.business.edutask.EdutaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EdurionDataRestAutoconfiguration {

    @Bean
    public EdutaskService edutaskService(EdutaskRepository edutaskRepository) {
        return new EdutaskService(edutaskRepository);
    }
}
