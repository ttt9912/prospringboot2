package ch.webfluxapp;

import ch.webfluxapp.data.ToDo;
import ch.webfluxapp.data.ToDoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

/*
 * @WebFluxTest
 * - auto-configures WebFlux infrastructure
 * - limits scan to web components @Controller, @JsonComponent, WebFluxConfigurer, etc. (like @WebMvcTest)
 * - Other @Components are mocked using @MockBean
 *
 * --> Does not work with functional endpoints (ToDoRouterConfig, ToDoHandler), since they are not loaded into
 *     ApplicationContext
 *
 * WebTestClient - testing version of WebClient
 */
@RunWith(SpringRunner.class)
@WebFluxTest
public class WebFluxTestTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    ToDoRepository toDoRepository;

    @Test
    public void reactiveTest() {
        given(toDoRepository.findAll()).willReturn(
                Flux.fromIterable(Arrays.asList(
                        new ToDo("1", "feed dog", null, null, false),
                        new ToDo("2", "go walk", null, null, false),
                        new ToDo("3", "read book", null, null, true))));

        webTestClient.get().uri("/todos").accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class);
    }

}