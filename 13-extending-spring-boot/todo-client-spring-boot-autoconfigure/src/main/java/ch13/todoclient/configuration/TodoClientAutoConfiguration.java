package ch13.todoclient.configuration;

import ch13.todoclient.client.TodoRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * @ConditionalOnClass - configuration is created if RestTemplateBuilder is on the Classpath
 */
@Slf4j
@Configuration
@ConditionalOnClass({RestTemplateBuilder.class})
@EnableConfigurationProperties(TodoClientProperties.class)
public class TodoClientAutoConfiguration {

    @Bean
    public TodoRestClient todoClient(RestTemplateBuilder builder, TodoClientProperties properties) {
        log.info("Creating a TodoRestClient {}", properties);
        return new TodoRestClient(restTemplate(builder), properties);
    }

    private RestTemplate restTemplate(final RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
                .build();
    }
}
