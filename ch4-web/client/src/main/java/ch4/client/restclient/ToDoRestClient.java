package ch4.client.restclient;

import ch4.client.ClientProperties;
import ch4.client.data.ToDo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

/*
 * RestTemplate - synchronous client side http access
 * - exchange RequestEntity, ResponseEntity
 * - provide request params in a map
 */
@Service
public class ToDoRestClient {
    private final RestTemplate restTemplate;
    private final ClientProperties properties;


    public ToDoRestClient(final RestTemplate restTemplate, final ClientProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    /*
     * - create RequestEntity
     * - ResponseEntity = RestTemplate.exchange(RequestEntity)
     */
    public Iterable<ToDo> findAll() throws URISyntaxException {
        RequestEntity<Iterable<ToDo>> requestEntity = new RequestEntity<>(
                HttpMethod.GET, new URI(properties.getUrl() + properties.getBasePath()));

        ResponseEntity<Iterable<ToDo>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Iterable<ToDo>>() {
                });

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return null;
    }

    /*
     * - create a param Map
     * - Entity = RestTemplate.getForObject(url, params)
     */
    public ToDo findById(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(
                properties.getUrl() + properties.getBasePath() + "/{id}", ToDo.class, params);
    }

    /*
     * POST
     */
    public ToDo upsert(ToDo toDo) throws URISyntaxException {
        RequestEntity<?> requestEntity = new RequestEntity<>(
                toDo, HttpMethod.POST, new URI(properties.getUrl() + properties.getBasePath()));

        ResponseEntity<Iterable<ToDo>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Iterable<ToDo>>() {
                });

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return restTemplate.getForObject(response.getHeaders().getLocation(), ToDo.class);
        }
        return null;
    }

    /*
     * PUT
     * - method=patch
     */
    public ToDo setCompleted(String id) throws URISyntaxException {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);

        restTemplate.postForObject(properties.getUrl() + properties.getBasePath()
                + "/{id}?_method=patch", null, ResponseEntity.class, params);

        return findById(id);
    }

    public void delete(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);

        restTemplate.delete(properties.getUrl() + properties.getBasePath() + "/{id}", params);
    }
}
