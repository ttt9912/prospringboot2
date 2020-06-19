package ch9.websocketsockjsclient.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Slf4j
@Component
public class PrintHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(final WebSocketSession session, final TextMessage message) throws Exception {
        log.info(">>> SOCKJS message received - {}", message);
    }
}
