package ch9.stompinterception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSocketMessageBroker
public class WebsocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(final MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app"); // receive
        registry.enableSimpleBroker("/topic", "/queue"); // send
    }

    @Override
    public void configureClientInboundChannel(final ChannelRegistration registration) {
        registration.interceptors(new LoggingChannelInterceptor());
    }

    @Override
    public void configureClientOutboundChannel(final ChannelRegistration registration) {
        registration.interceptors(new LoggingChannelInterceptor());
    }

    @Autowired AbstractSubscribableChannel brokerChannel;

    @PostConstruct
    public void brokerChannel() {
        brokerChannel.addInterceptor(new LoggingChannelInterceptor());
    }
}
