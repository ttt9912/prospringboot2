package app.producer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoProducer {
    private final JmsTemplate jmsTemplate;

    public TodoProducer(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(String destination, Todo todo) {
        jmsTemplate.convertAndSend(destination, todo);
        log.info("TodoProducer > message sent {}", todo);
    }
}
