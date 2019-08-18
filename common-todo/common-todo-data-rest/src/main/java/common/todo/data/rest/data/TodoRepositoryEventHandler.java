package common.todo.data.rest.data;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/*
 * spring-data-rest ignores JPA lifecycle annotations like @PreUpdate
 */
@Slf4j
@Component
@RepositoryEventHandler(Todo.class)
public class TodoRepositoryEventHandler {


    @HandleBeforeCreate
    public void onCreate(Todo todo) {
        todo.setCreated(LocalDateTime.now());
        todo.setModified(LocalDateTime.now());
        todo.setCompleted(false);
    }

    @HandleBeforeSave
    public void onUpdate(Todo todo) {
        todo.setModified(LocalDateTime.now());
    }
}
