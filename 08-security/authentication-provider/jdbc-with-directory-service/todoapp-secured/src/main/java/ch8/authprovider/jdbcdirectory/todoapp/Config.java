package ch8.authprovider.jdbcdirectory.todoapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Configuration
public class Config {

    @Value("${person.directory.username}")
    private String username;

    @Value("${person.directory.password}")
    private String password;

    @Bean
    RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.basicAuthentication(username, password).build();
    }
}
