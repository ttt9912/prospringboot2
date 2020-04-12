package ch9.simpsendtouser.endpoint;

import ch9.simpsendtouser.data.IncomingChatMessage;
import ch9.simpsendtouser.data.OutgoingChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/*
 * TODO
 * -------------------------------------------------
 * /queue
 * -------------------------------------------------
 * Convention: Use /queue/ instead of /topic/ to target a specific user
 *
 * Client subscribes to: /user/queue/echo
 *
 * Server Sends to: /user/{username}/queue/position-updates
 * user destination is handled by UserDestinationMessageHandler
 *
 * /user/{username}/queue/position-updates, which in turn is translated by the
 * UserDestinationMessageHandler into one or more destinations, one for each
 * session associated with the user
 */
@Slf4j
@Controller
public class ChatController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public ChatController(final SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @MessageMapping("/chat") // listen to /app/echo
    public void handle(final IncomingChatMessage message, final Principal principal) {
        log.info(">>> received from user {} - {}", principal.getName(), message);

        // send to /user/{username}/queue/chat
        simpMessagingTemplate.convertAndSendToUser(message.getTo(), "/queue/chat",
                new OutgoingChatMessage(principal.getName(), message.getText()));
    }
}
