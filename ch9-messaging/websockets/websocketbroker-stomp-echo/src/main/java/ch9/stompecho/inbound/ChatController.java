package ch9.stompecho.inbound;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/*
 * messages are from a WebSocket connection are decoded to STOMP frames
 * and then turned into a Spring Message
 *
 *
 */
@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/chat") // listen to /app/chat
    // @SendTo("/topic/chat") // optional here, /app is automatically replaced with /topic
    public ChatMessage handle(final ChatMessage chatMessage) {
        log.info(">>> received - {}", chatMessage);
        return chatMessage; // send to /topic/chat
    }
}
