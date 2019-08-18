package ch4.client.restclient;

import ch4.client.ClientProperties;
import ch4.client.dto.ToDoDto;
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
    public Iterable<ToDoDto> findAll() throws URISyntaxException {
        RequestEntity<Iterable<ToDoDto>> requestEntity = new RequestEntity<>(
                HttpMethod.GET, new URI(properties.getUrl() + properties.getBasePath()));

        ResponseEntity<Iterable<ToDoDto>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Iterable<ToDoDto>>() {
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
    public ToDoDto findById(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(
                properties.getUrl() + properties.getBasePath() + "/{id}", ToDoDto.class, params);
    }

    /*
     * POST
     */
    public ToDoDto upsert(ToDoDto todoDto) throws URISyntaxException {
        RequestEntity<?> requestEntity = new RequestEntity<>(
                todoDto, HttpMethod.POST, new URI(properties.getUrl() + properties.getBasePath()));

        ResponseEntity<Iterable<ToDoDto>> response = restTemplate.exchange(requestEntity,
                new ParameterizedTypeReference<Iterable<ToDoDto>>() {
                });

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return restTemplate.getForObject(response.getHeaders().getLocation(), ToDoDto.class);
        }
        return null;
    }

    /*
     * PUT
     * - method=patch
     */
    public ToDoDto setCompleted(String id) throws URISyntaxException {
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
