package ch9.jms.pointtopoint.consumer;

import common.todo.data.jpa.todo.Todo;
import common.todo.data.jpa.todo.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/*
 * Point-to-Point pattern: only one @JmsListener will receive the message
 */
@Slf4j
@Component
public class TodoConsumer {
    private final TodoRepository todoRepository;

    public TodoConsumer(final TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /*
     * Typed
     */
    @JmsListener(destination = "${todo.jms.destination}", containerFactory = "jmsFactory")
    public void process(Todo todo) {
        log.info("TodoConsumer > received Todo {}", todo);
    }

    /*
     * Generic
     */
    @JmsListener(destination = "${todo.jms.destination}", containerFactory = "jmsFactory")
    public void process(TextMessage message) throws JMSException {
        log.info("TextMessageConsumer > received message {}", message.getText());
    }
}
