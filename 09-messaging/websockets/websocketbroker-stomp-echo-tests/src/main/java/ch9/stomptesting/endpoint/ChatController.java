package ch9.stomptesting.endpoint;

import ch9.stomptesting.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class ChatController {

    @MessageMapping("/msg")
    public ChatMessage handle(final ChatMessage message) {
        log.info(">>> received - {}", message);
        return message;
    }

}
