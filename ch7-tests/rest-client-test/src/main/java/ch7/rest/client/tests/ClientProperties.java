package ch7.rest.client.tests;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
 * Custom-typed property
 *
 * @ConfigurationProperties - map properties from application.properties
 */
@Component
@ConfigurationProperties(prefix = "todo")
@Data
public class ClientProperties {
    private String url;
    private String basePath;
}
