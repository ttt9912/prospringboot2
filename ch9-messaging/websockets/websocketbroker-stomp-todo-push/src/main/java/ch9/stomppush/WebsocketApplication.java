package ch9.stomppush;

import ch9.stomppush.data.TodoUpdater;
import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/*
 * Embedded Websocket
 *
 * Push Technology:
 * - long-held single TCP socket connections between the client and server
 *
 *
 * Go to localhost:8080
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
@EnableScheduling
public class WebsocketApplication {

    @Autowired
    private TodoUpdater todoUpdater;

    public static void main(String[] args) {
        SpringApplication.run(WebsocketApplication.class, args);
    }

    @Scheduled(fixedRate = 2 * 1000)
    public void modifyTodos() {
        todoUpdater.udpateRandomTodo();
    }
}
