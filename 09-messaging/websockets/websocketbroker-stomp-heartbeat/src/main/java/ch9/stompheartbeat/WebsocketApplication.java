package ch9.stompheartbeat;

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

    @Scheduled(fixedRate = 30 * 1000)
    public void modifyTodos() {
        // simp.convertAndSend("/topic/greeting", "Hello");
    }
}
