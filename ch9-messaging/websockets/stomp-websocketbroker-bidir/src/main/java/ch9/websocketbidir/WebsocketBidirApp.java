package ch9.websocketbidir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*
 * go to localhost:8080
 */
@SpringBootApplication
public class WebsocketBidirApp {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketBidirApp.class, args);
    }
}
