package ch7.web.endpoint.tests.service;

import ch7.web.endpoint.tests.data.ToDo;
import ch7.web.endpoint.tests.data.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final ToDoService repository;

    public TodoController(final ToDoService repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public ResponseEntity<Collection<ToDo>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }
}
