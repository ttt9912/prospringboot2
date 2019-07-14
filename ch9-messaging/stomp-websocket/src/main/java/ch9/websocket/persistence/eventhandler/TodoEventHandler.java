package ch9.websocket.persistence.eventhandler;

import ch9.websocket.TodoWsProperties;
import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

/*
 *
 *

@Slf4j
@Component
@RepositoryEventHandler(Todo.class)
public class TodoEventHandler {
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final TodoWsProperties todoWsProperties;

    public TodoEventHandler(final SimpMessagingTemplate simpMessagingTemplate, final TodoWsProperties todoWsProperties) {
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.todoWsProperties = todoWsProperties;
    }

    @HandleAfterCreate
    @HandleAfterSave
    public void handleTodoSave(Todo todo) {
        simpMessagingTemplate.convertAndSend(todoWsProperties.getBroker() + "/new", todo);
        log.info("sending message to ws://todo/new - {}", todo);
    }
}
 */