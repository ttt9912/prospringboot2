package ch9.websocketsockjs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ----------------------------------------------------
 * Javascript with sockjs-client
 * ----------------------------------------------------
 * now uses sockjs-client
 * (https://github.com/sockjs/sockjs-client/)
 *
 * SockJS('http://localhost:8080/echo'); instead of
 * Websocket('ws://localhost:8080/echo'); this will no longer work anyway
 *
 * go to localhost:8080
 */
@SpringBootApplication
public class WebsocketSockJsApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketSockJsApp.class, args);
    }
}
