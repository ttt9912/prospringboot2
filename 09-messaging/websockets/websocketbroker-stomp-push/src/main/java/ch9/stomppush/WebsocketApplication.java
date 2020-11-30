package ch9.stomppush;

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

    @Autowired
    private SimpMessagingTemplate simp;

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Scheduled(fixedRate = 2 * 1000)
    public void modifyTodos() {
        System.out.println("sending message");
        simp.convertAndSend("/topic/greeting", "Hello");
    }
}
