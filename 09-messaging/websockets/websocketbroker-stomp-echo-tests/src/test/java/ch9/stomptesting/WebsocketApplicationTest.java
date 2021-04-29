package ch9.stomptesting;

import ch9.stomptesting.data.ChatMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Scanner;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class WebsocketApplicationTest {

    @LocalServerPort
    int port;

    @Test
    public void test() {
        final StompClient stompClient = new StompClient();
        stompClient.connect(port);

        stompClient.send("/app/msg", new ChatMessage("Peter", "Hi"));
    }
}
