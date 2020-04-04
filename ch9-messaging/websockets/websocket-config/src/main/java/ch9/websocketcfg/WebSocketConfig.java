package ch9.websocketcfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

/*
 * -------------------------------------------
 * ServletServerContainerFactoryBean
 * -------------------------------------------
 * configure runtime properties
 *
 * -------------------------------------------
 * CORS / allowed origins
 * -------------------------------------------
 * by default, only same origin requests are allowed
 *
 * set allowed origins:
 * https://docs.spring.io/spring-framework/docs/5.2.x/spring-framework-reference/web.html#websocket-server-allowed-origins
 *
 *
 * Send messages to: ws://localhost:8080/echo
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private TextEchoHandler echoHandler;

    @Override
    public void registerWebSocketHandlers(final WebSocketHandlerRegistry registry) {
        registry.addHandler(echoHandler, "/echo");
    }

    /*
     * Configure Websocket runtime properties
     * via ServletServerContainerFactoryBean
     */
    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxTextMessageBufferSize(8192);
        container.setMaxBinaryMessageBufferSize(8192);
        return container;
    }

    /*
     * ---------------------------
     * Config with Jetty
     * ---------------------------
     */
    /*
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoHandler,
                "/echo").setHandshakeHandler(handshakeHandler());
    }

    @Bean
    public DefaultHandshakeHandler handshakeHandler() {

        WebSocketPolicy policy = new WebSocketPolicy(WebSocketBehavior.SERVER);
        policy.setInputBufferSize(8192);
        policy.setIdleTimeout(600000);

        return new DefaultHandshakeHandler(
                new JettyRequestUpgradeStrategy(new WebSocketServerFactory(policy)));
    }
     */
}
