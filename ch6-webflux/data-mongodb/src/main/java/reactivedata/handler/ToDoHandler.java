package reactivedata.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactivedata.data.ToDo;
import reactivedata.data.ToDoReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
public class ToDoHandler {
    private final ToDoReactiveRepository repository;

    public ToDoHandler(final ToDoReactiveRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> getToDo(ServerRequest request) {
        return findById(request.pathVariable("id"));
    }

    public Mono<ServerResponse> getToDos(final ServerRequest request) {
        Flux<ToDo> toDos = repository.findAll();

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(toDos, ToDo.class);
    }

    public Mono<ServerResponse> createToDo(final ServerRequest request) {
        Mono<ToDo> toDo = request.bodyToMono(ToDo.class);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(toDo.flatMap(this::save), ToDo.class));
    }

    private Mono<ToDo> save(final ToDo toDo) {
        return Mono.fromSupplier(() -> {
            repository.save(toDo)
                    .subscribe();
            return toDo;
        });
    }

    private Mono<ServerResponse> findById(final String id) {
        Mono<ToDo> toDo = repository.findById(id);

        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return toDo.flatMap(t -> ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(fromObject(t)))
                .switchIfEmpty(notFound);
    }
}
