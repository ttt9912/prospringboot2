package ch9.websocketcfg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/*
 * --------------------------------------
 * TextWebSocketHandler
 * --------------------------------------
 * process text messages only
 * for Binary messages use BinaryWebSocketHandler
 * or AbstractWebSocketHandler
 *
 * --------------------------------------
 * TextMessage
 * --------------------------------------
 * implementation of WebsocketMessage<T>

 * other WebsocketMessage<T> implementations
 * - BinaryMessage, PingMessage, PongMessage
 *
 * --------------------------------------
 * WebSocketSession
 * --------------------------------------
 * messages are sent via WebSocketSession
 *
 * Get the WebSocketSession
 * - override handleTextMessage()
 * - override afterConnectionEstablished()
 *
 */
@Slf4j
@Component
public class TextEchoHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(final WebSocketSession session, final TextMessage message) throws Exception {
        log.info(">>> MESSAGE - {}", message);
        session.sendMessage(message);
    }
}
