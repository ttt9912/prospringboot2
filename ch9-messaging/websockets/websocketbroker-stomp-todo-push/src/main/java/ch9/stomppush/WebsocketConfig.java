package ch9.stomppush;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
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
@EnableConfigurationProperties(TodoWsProperties.class)
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    private final TodoWsProperties properties;

    public WebsocketConfig(final TodoWsProperties properties) {
        this.properties = properties;
    }

    /*
     * - registers the STOMP protocol
     * - registers the /stomp endpoint
     * - uses the JavaScript library SockJS
     */
    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint(properties.getEndpoint())
                .setAllowedOrigins("*")
                .withSockJS();
    }

    /*
     * - enables the broker in the /todos endpoint.
     */
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(properties.getBroker());
        registry.setApplicationDestinationPrefixes(properties.getApp());
    }
}
