package ch9.stomppush.data;

import ch9.stomppush.TodoWsProperties;
import common.todo.data.jpa.todo.Todo;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.jpa.util.RepositoryUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoUpdater {
    private final TodoRepository todoRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final TodoWsProperties todoWsProperties;

    public TodoUpdater(final TodoRepository todoRepository, final SimpMessagingTemplate simpMessagingTemplate, final TodoWsProperties todoWsProperties) {
        this.todoRepository = todoRepository;
        this.simpMessagingTemplate = simpMessagingTemplate;
        this.todoWsProperties = todoWsProperties;
    }

    public void udpateRandomTodo() {
        final Todo existing = findRandomTodo();

        existing.setDescription(existing.getDescription() + " edited");
        todoRepository.save(existing);

        log.info("sending message to ws:/{}/new - {}", todoWsProperties.getBroker(), existing);
        simpMessagingTemplate.convertAndSend(todoWsProperties.getBroker() + "/new", existing);
    }

    private Todo findRandomTodo() {
        return RepositoryUtil.toList(todoRepository.findAll()).stream().findAny().orElse(null);
    }
}
