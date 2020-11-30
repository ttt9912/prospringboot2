package ch9.stomptesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*
 * Go to localhost:8080
 */
@SpringBootApplication
@EnableScheduling
public class WebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    // @Autowired
    // private SimpMessagingTemplate simp;

    // @Scheduled(initialDelay = 2_000, fixedRate = 10_000)
    public void push() {
        System.out.println("sending message");
        // simp.convertAndSend("/topic/greeting", "Hello");
    }
}
