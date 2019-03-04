package todoclient.restclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import todoclient.data.ToDo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

@Service
public class ToDoRestClient {
    private final RestTemplate restTemplate;

    @Value("${todo.url}")
    private String url;
    @Value("${todo.base-path}")
    private String basePath;


    public ToDoRestClient(final RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public Iterable<ToDo> findAll() throws URISyntaxException {
        RequestEntity<Iterable<ToDo>> requestEntity = new RequestEntity<>(
                HttpMethod.GET, new URI(url + basePath));

        ResponseEntity<Iterable<ToDo>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Iterable<ToDo>>() {
                });

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    public ToDo findById(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(url + basePath + "/{id}", ToDo.class, params);
    }
}
