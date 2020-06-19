package ch6.webflux.webflux.data;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Repository
public class ToDoRepository {
    private final Flux<ToDo> cache = Flux.fromIterable(Arrays.asList(
            new ToDo(1, "feed dog", false),
            new ToDo(2, "go walk", false),
            new ToDo(3, "read book", true)
    ));

    public Flux<ToDo> findAll() {
        return cache;
    }

    public Mono<ToDo> findById(final Integer id) {
        return Mono.from(
                cache.filter(toDo -> toDo.getId().equals(id))
        );
    }
}
