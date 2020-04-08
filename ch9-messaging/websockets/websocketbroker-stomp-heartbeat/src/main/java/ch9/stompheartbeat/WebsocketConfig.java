package ch9.stompheartbeat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {
    private final TaskScheduler taskScheduler;

    public WebsocketConfig(final TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    /*
     * setTaskScheduler - enable stomp hearbeats
     * sets the #setHeartbeatValue to "10000, 10000"
     *
     * setHeartbeatValue - first number represents how often (ms) the server will write or send a heartbeat,
     * the second is how often (ms) the client should write
     *
     * server heartbeat sends each 5, client each 10
     */
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic")
                .setTaskScheduler(this.taskScheduler)
                .setHeartbeatValue(new long[]{5000, 10000});
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/greetings")
                .setAllowedOrigins("*")
                .withSockJS();
    }

}
