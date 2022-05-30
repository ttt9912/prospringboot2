package ch5.data.jpa.envers;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableEnversRepositories
@EnableTransactionManagement
public class Config {
}
