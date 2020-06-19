package ch11.file.integration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "todo")
public class TodoFileProperties {
    private String directory;
    private String filePattern;
}
