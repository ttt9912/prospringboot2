package ch9.websocketsockjsclient.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.RestTemplateXhrTransport;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.Transport;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;

import java.util.List;

@Configuration
public class SockJsClientConfig {

    /*
     * SockJS Java client supports the following transports:
     * - websocket
     * - xhr-streaming
     * - xhr-polling
     */
    private static List<Transport> transports() {
        return List.of(
                new WebSocketTransport(new StandardWebSocketClient()),
                new RestTemplateXhrTransport()
        );
    }

    @Bean
    public SockJsClient sockJsClient() {
        return new SockJsClient(transports());
    }
}
