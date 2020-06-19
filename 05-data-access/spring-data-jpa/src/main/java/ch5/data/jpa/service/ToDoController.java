package ch5.data.jpa.service;

import ch5.data.jpa.data.RepositoryUtil;
import ch5.data.jpa.data.ToDo;
import ch5.data.jpa.data.ToDoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    private final ToDoRepository repository;

    public ToDoController(final ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ToDo> findAll() {
        return RepositoryUtil.toList(repository.findAll());
    }
}
