package ch9.stompecho.endpoint;

import ch9.stompecho.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/*
 * messages are from a WebSocket connection are decoded to STOMP frames
 * and then turned into a Spring Message
 *
 * -------------------------------------------------
 * @MessageMapping - path value
 * -------------------------------------------------
 * ant style
 *
 * -------------------------------------------------
 * @MessageMapping - allowed method arguments
 * -------------------------------------------------
 * - Message, MessageHeaders, and others
 * - @Payload, @Headers, @Header
 * - Principal
 *
 * see https://docs.spring.io/spring-framework/docs/5.2.x/spring-framework-reference/web.html#websocket-stomp-message-mapping
 *
 * -------------------------------------------------
 * @MessageMapping - return value
 * -------------------------------------------------
 * By default, the return value from a @MessageMapping method is serialized to a payload through a matching
 * MessageConverter and sent as a  Message to the brokerChannel, from where it is broadcast to subscribers
 *
 * @SendTo and @SendToUser annotations can be used to customize the destination of the output message
 * They can also be used on class level
 *
 * Messages can be handled asynchronously and a @MessageMapping method can return ListenableFuture,
 * CompletableFuture, or CompletionStage.
 *
 * -------------------------------------------------
 * @MessageExceptionHandler
 * -------------------------------------------------
 * - handle exceptions from @MessageMapping methods
 * - exceptions can be declared in the annotation itself or through a method argument
 * - global exception handling: with @ControllerAdvice
 *
 */
@Slf4j
@Controller
public class ChatController {


    @MessageMapping("/chatmessage") // listen to /app/chat
    // @SendTo("/topic/chat") // optional here, /app is automatically replaced with /topic
    public ChatMessage handle(final ChatMessage chatMessage) {
        log.info(">>> received - {}", chatMessage);
        return chatMessage; // send to /topic/chat
    }

    /*
    // Alternative: access the Spring Message
    @MessageMapping("/chat")
    public Message<ChatMessage> handle(final Message<ChatMessage> message) {
        log.info(">>> received - {}", message);
        return message;
    }
     */

    @MessageExceptionHandler
    public RuntimeException handleException(RuntimeException exception) {
        log.error("Error", exception);
        return exception;
    }
}
