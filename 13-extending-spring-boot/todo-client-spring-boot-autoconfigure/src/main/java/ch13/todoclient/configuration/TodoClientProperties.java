package ch13.todoclient.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "todoclient")
public class TodoClientProperties {
    private String host = "http://localhost:10000";
    private String path = "/api/todos";
}
