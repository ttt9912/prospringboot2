package ch5.data.rest.repository.eventhandler.eventhandler;

import ch5.data.rest.repository.eventhandler.data.ToDo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

/*
 * @RepositoryEventHandler
 * - tells the BeanPostProcessor that this class needs to be inspected for handler methods
 * - parameter can be omitted and methods with different entity classes can be defined
 *
 */
@Slf4j
@Component
@RepositoryEventHandler(ToDo.class)
public class TodoEventHandler {


    @HandleBeforeCreate
    public void handleTodoBeforeCreate(ToDo todo) {
        log.info("TodoEventHandler > before-create of Todo {}", todo);
    }

    @HandleAfterCreate
    public void handleAfterCreate(ToDo todo) {
        log.info("TodoEventHandler > after-create of Todo {}", todo);
    }

    @HandleAfterDelete
    public void handleAfterDelete(ToDo todo) {
        log.info("TodoEventHandler > after-delete of Todo {}", todo);
    }

    @HandleAfterSave
    public void handleAfterSave(ToDo todo) {
        log.info("TodoEventHandler > after-save of Todo {}", todo);
    }
}
