package ch7.webflux.tests.controller;

import ch7.webflux.tests.data.ToDo;
import ch7.webflux.tests.data.ToDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ToDoController {
    private final ToDoRepository toDoRepository;

    public ToDoController(final ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todos")
    public Flux<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    @GetMapping("/todos/{id}")
    public Mono<ToDo> findById(@PathVariable final String id) {
        return toDoRepository.findById(id);
    }

}
