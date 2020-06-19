package ch6.webflux.webflux.handler;

import ch6.webflux.webflux.data.ToDo;
import ch6.webflux.webflux.data.ToDoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class ToDoHandler {
    private final ToDoRepository toDoRepository;

    public ToDoHandler(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public Mono<ServerResponse> getToDo(final ServerRequest request) {
        String id = request.pathVariable("id");

        return toDoRepository.findById(Integer.valueOf(id))
                .flatMap(toDo ->
                        ServerResponse.ok()
                                .contentType(APPLICATION_JSON)
                                .body(fromObject(toDo)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getToDos(final ServerRequest request) {
        Flux<ToDo> all = toDoRepository.findAll();

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(all, ToDo.class);
    }
}
