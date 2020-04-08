package ch9.stomppush;

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
     * - registers the STOMP protocol
     * - registers the /greetings endpoint
     * - uses the JavaScript library SockJS
     */
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/greetings")
                .setAllowedOrigins("*")
                .withSockJS();
    }

    /*
     * - client receives message events under    /topic/*
     */
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }
}
