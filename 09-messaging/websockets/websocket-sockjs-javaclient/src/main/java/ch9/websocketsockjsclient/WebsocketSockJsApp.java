package ch9.websocketsockjsclient;

import ch9.websocketsockjsclient.client.PrintHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.sockjs.client.SockJsClient;

import java.io.IOException;

@SpringBootApplication
public class WebsocketSockJsApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketSockJsApp.class, args);
    }

    @Bean
    public CommandLineRunner client(final SockJsClient sockJsClient, PrintHandler printHandler) {
        return args -> {
            sockJsClient.doHandshake(printHandler, "ws://localhost:8080/echo")
                    .addCallback(new ListenableFutureCallback<>() {
                        @Override
                        public void onSuccess(final WebSocketSession session) {
                            try {
                                session.sendMessage(new TextMessage("Hello"));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(final Throwable ex) {
                            ex.printStackTrace();
                        }
                    });
        };
    }
}
