package ch10.actuator.custom.endpoints.actuator;

import common.todo.data.jpa.todo.Todo;
import common.todo.data.jpa.todo.TodoRepository;
import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

/*
 * - @ReadOperation = GET
 * - @WriteOperation = POST
 * - @DeleteOperation = DELETE
 *
 * - @Selector: parameter of an endpoint method
 *
 * - id: endpoint path (/actuator/todostats)
 */
@Component
@Endpoint(id = "todostats")
public class TodoStatsEndpoint {
    private final TodoRepository todoRepository;

    public TodoStatsEndpoint(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @ReadOperation
    public TodoStats todoStats() {
        return new TodoStats(todoRepository.count(), todoRepository.countByCompleted(true));
    }

    @ReadOperation
    public Todo getTodo(@Selector String id) {
        return todoRepository.findById(id).orElse(null);
    }

    @WriteOperation
    public TodoOperation completeTodo(@Selector String id) {
        Todo todo = todoRepository.findById(id).orElse(null);

        if (todo == null) {
            return new TodoOperation("COMPLETED", false);
        }

        todo.setCompleted(true);
        todoRepository.save(todo);
        return new TodoOperation("COMPLETED", true);
    }

    @DeleteOperation
    public TodoOperation removeTodo(@Selector String id) {
        try {
            todoRepository.deleteById(id);
            return new TodoOperation("DELETED", true);
        } catch (Exception ex) {
            return new TodoOperation("DELETED", false);
        }
    }
}
