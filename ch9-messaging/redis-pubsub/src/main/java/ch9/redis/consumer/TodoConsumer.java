package ch9.redis.consumer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoConsumer {

    /*
     * - it is mandatory to have a handleMessage method name
     * - this is a constraint when creating a MessageListenerAdapter
     */
    public void handleMessage(Todo todo) {
        log.info("TodoConsumer > received Todo {}", todo);
    }
}
