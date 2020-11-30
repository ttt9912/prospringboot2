package ch9.stompinterception.endpoint;

import ch9.stompinterception.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
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
