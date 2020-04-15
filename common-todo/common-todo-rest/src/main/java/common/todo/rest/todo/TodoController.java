package common.todo.rest.todo;

import common.todo.data.jpa.todo.Todo;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.jpa.util.RepositoryUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> findAll() {
        return RepositoryUtil.toList(todoRepository.findAll());
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable("id") final String id) {
        return todoRepository.findById(id)
                .orElse(null);
    }
}
