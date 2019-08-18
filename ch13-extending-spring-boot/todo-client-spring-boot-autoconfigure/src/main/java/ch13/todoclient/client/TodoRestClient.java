package ch13.todoclient.client;

import ch13.todoclient.configuration.TodoClientProperties;
import ch13.todoclient.dto.TodoDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
public class TodoRestClient {
    private final RestTemplate restTemplate;
    private final TodoClientProperties properties;

    public TodoDto findById(final String id) {
        final ResponseEntity<TodoDto> response = restTemplate.getForEntity(
                properties.getHost() + properties.getPath() + "/{id}", TodoDto.class, id);
        return response.getBody();
    }
}
