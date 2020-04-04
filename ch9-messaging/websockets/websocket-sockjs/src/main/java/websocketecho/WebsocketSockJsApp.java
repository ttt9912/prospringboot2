package websocketecho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * JS client now uses SockJS('http://localhost:8080/echo');
 * instead of Websocket('ws://localhost:8080/echo');
 *
 * go to localhost:8080
 */
@SpringBootApplication
public class WebsocketSockJsApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketSockJsApp.class, args);
    }
}
