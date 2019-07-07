package ch7.webflux.tests.data;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;

import static java.time.LocalDateTime.now;

@Repository
public class ToDoRepository {
    private final Flux<ToDo> cache = Flux.fromIterable(Arrays.asList(
            new ToDo("1", "feed dog", now(), now(), false),
            new ToDo("2", "go walk", now(), now(), false),
            new ToDo("3", "read book", now(), now(), true)
    ));

    public Flux<ToDo> findAll() {
        return cache;
    }

    public Mono<ToDo> findById(final String id) {
        return Mono.from(
                cache.filter(toDo -> toDo.getId().equals(id))
        );
    }
}
