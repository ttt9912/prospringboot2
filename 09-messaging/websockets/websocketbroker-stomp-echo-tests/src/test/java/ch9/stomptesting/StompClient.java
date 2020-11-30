package ch9.stomptesting;

import ch9.stomptesting.data.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
public class StompClient {
    private final MyStompSessionHandler sessionHandler = new MyStompSessionHandler();
    private StompSession stompSession = null;

    public void connect(int port) {
        final String url = String.format("ws://127.0.0.1:%d/chat", port);
        log.info("connecting to {}", url);

        final WebSocketStompClient stompClient = new WebSocketStompClient(new SockJsClient(createTransports()));
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());
        try {
            stompSession = stompClient.connect(url, sessionHandler).get();
            stompSession.subscribe("/topic/**", new StompFrameHandler() {
                @Override
                public Type getPayloadType(final StompHeaders headers) {
                    return ChatMessage.class;
                }

                @Override
                public void handleFrame(final StompHeaders headers, final Object payload) {
                    log.info("[Frame] >>> {}", payload);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private List<Transport> createTransports() {
        return List.of(new WebSocketTransport(new StandardWebSocketClient()));
    }

    public void send(final String destination, final ChatMessage chatMessage) {
        stompSession.send(destination, chatMessage);
    }
}
