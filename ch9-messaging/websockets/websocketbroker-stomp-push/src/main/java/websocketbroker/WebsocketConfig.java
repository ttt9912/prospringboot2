package websocketbroker;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/*
 * WebSocketMessageBrokerConfigurer - overrides methods to customize the protocols and endpoints
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    /*
     * /chat is the HTTP URL for the endpoint
     * to which a WebSocket (or SockJS) client needs to
     * connect for the WebSocket handshake
     */
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .withSockJS();
    }

    /*
     * receive - STOMP messages whose destination header begins with /app are
     *           routed to @MessageMapping methods in @Controller classes
     *
     * send - messages whose destination header begins with /topic or /queue
     *        are routed to the broker for subscriptions and broadcasting
     */
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // receive
        registry.enableSimpleBroker("/topic", "/queue"); // send
    }
}
