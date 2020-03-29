package ch9.websocketbidir.chat;

import ch9.websocketbidir.model.IncomingMessage;
import ch9.websocketbidir.model.OutgoingMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Controller
public class ChatMessageProcessor {

    /*
     * - subscribe to   /app/new-message
     *
     * - send to        /topic/messages
     */
    @MessageMapping("/new-message")
    @SendTo("/topic/messages")
    public OutgoingMessage send(final IncomingMessage message) {
        log.info("message received - {}", message);

        final OutgoingMessage outgoingMessage = createOutgoingMessage(message);

        log.info("sending message - {}", outgoingMessage);
        return outgoingMessage;
    }

    private OutgoingMessage createOutgoingMessage(final IncomingMessage message) {
        return new OutgoingMessage(
                message.getFrom(),
                message.getContent(),
                dateToString(LocalDateTime.now())
        );
    }

    private String dateToString(final LocalDateTime localDateTime) {
        return DateTimeFormatter.ISO_DATE_TIME.format(localDateTime);
    }
}
