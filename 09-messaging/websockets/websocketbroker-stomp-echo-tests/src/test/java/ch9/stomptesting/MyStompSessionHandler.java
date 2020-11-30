package ch9.stomptesting;

import ch9.stomptesting.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;

import java.lang.reflect.Type;

@Slf4j
public class MyStompSessionHandler implements StompSessionHandler {

    @Override
    public void afterConnected(final StompSession session, final StompHeaders connectedHeaders) {
        log.info("connected");
    }

    @Override
    public void handleException(final StompSession session, final StompCommand command, final StompHeaders headers, final byte[] payload, final Throwable exception) {
        log.error("error", exception);
    }

    @Override
    public void handleTransportError(final StompSession session, final Throwable exception) {
        log.error("error", exception);
    }

    @Override
    public Type getPayloadType(final StompHeaders headers) {
        return ChatMessage.class;
    }

    @Override
    public void handleFrame(final StompHeaders headers, final Object payload) {
        log.info("[StompClient] >>> {}", payload);
    }
}
