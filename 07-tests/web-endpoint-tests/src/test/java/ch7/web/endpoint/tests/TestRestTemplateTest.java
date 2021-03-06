package ch7.web.endpoint.tests;

import ch7.web.endpoint.tests.data.ToDo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/*
 * ---------------------------------------------------------------------------------
 * running a full server
 * ---------------------------------------------------------------------------------
 *
 * # TestRestTemplate
 * - Http Methods (getForObject(), getForEntity(), post(), etc)
 * - exchange: with RequestEntity/ResponseEntity
 *
 * TestRestTemplate provided by @SpringBootTest
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT) // full server
public class TestRestTemplateTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getTodos() {
        String body = testRestTemplate.getForObject("/api/todos", String.class);

        assertThat(body).contains("feed dog");
    }

    @Test
    public void getTodos_exchange() throws URISyntaxException {
        RequestEntity<Iterable<ToDo>> request = new RequestEntity<>(
                HttpMethod.GET, new URI("http://localhost:" + port + "/api/todos"));

        ResponseEntity<Collection<ToDo>> response = testRestTemplate.exchange(request,
                new ParameterizedTypeReference<Collection<ToDo>>() {
                });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(2);
    }
}
