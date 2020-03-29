package ch9.websocket;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "todo.ws")
public class TodoWsProperties {
    private String app = "/todo-api-ws";
    private String broker = "/todo";
    private String endpoint = "/stomp";
}
