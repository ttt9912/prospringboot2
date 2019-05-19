package todoapp.directory.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


/*
 * connect to person-directory and load username
 *
 * Directory app responds with a HAL+JSON protocol
 */
@Slf4j
@Service
public class PersonDirectoryService {
    private final RestTemplate restTemplate;

    @Value("${person.directory.find-by-email-uri}")
    private String findPersonUri;

    public PersonDirectoryService(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Person loadPersonByEmail(final String username) {
        URI uri = URI.create(UriComponentsBuilder
                .fromUriString(findPersonUri)
                .queryParam("email", username).toUriString());

        try {
            return restTemplate.getForObject(uri, Person.class);
        } catch (ResourceAccessException e) {
            log.error("failed to connect to PersonDirectory");
            e.printStackTrace();
            return null;
        } catch (HttpClientErrorException.NotFound e) {
            log.info("no Person found with email={}", username);
            return null;
        }
    }
}
