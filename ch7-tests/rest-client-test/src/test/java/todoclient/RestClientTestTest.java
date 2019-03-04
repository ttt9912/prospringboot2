package todoclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import todoclient.data.ToDo;
import todoclient.restclient.ToDoRestClient;
import util.FileAsStringReader;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/*
 * Testing Rest Client Applications
 *
 * @RestClientTest
 * - to be used with a Client that uses RestTemplate & RestTemplateBuilder
 * - auto-configures Jackson, GSON, JSONB, RestTemplateBuilder
 * - adds support for MockRestServiceServer
 * - @Component etc. are ignored
 *
 * MockRestServiceServer - mocking the remote server
 *
 */
@RunWith(SpringRunner.class)
@RestClientTest(ToDoRestClient.class)
public class RestClientTestTest {

    @Autowired
    private ToDoRestClient toDoRestClient;

    @Autowired
    private MockRestServiceServer server;

    @Test
    public void restClientTest() throws IOException {
        final String content = FileAsStringReader.readFile("read-book.json");

        server.expect(requestTo("http://localhost:8080/api/todos/my-id"))
                .andRespond(withSuccess(content, APPLICATION_JSON_UTF8));

        ToDo result = toDoRestClient.findById("my-id");

        assertThat(result.getDescription()).isEqualTo("read book");
    }
}