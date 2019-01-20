package todoclient.restclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import todoclient.ClientProperties;
import todoclient.data.ToDo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

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
        RequestEntity<Iterable<ToDo>> requestEntity =
                new RequestEntity<>(HttpMethod.GET, new URI(properties.getUrl() + properties.getBasePath()));

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
     * - RestTemplate.getForObject(url, params)
     */
    public ToDo findById(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(properties.getUrl() + properties.getBasePath() + "/{id}", ToDo.class,
                params);
    }
}
