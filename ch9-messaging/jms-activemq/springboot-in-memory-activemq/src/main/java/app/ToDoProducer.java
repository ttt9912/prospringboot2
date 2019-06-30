package app;

import common.todo.data.jpa.todo.Todo;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ToDoProducer {
    private final JmsTemplate jmsTemplate;

    public ToDoProducer(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void convertAndSend(String destination, Todo toDo) {

    }
}
