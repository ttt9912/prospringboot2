package ch.webapp.service;

import ch.webapp.data.ToDo;
import ch.webapp.data.ToDoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final ToDoRepository repository;

    public TodoController(final ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public ResponseEntity<Collection<ToDo>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
