package ch9.websocket.persistence.eventhandler;

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