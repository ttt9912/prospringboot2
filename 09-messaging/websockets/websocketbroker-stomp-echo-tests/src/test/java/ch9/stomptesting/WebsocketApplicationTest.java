package ch9.stomptesting;

import ch9.stomptesting.data.ChatMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Scanner;

import static org.springframework.boot.test.context.SpringBootTest.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(SpringRunner.class)
public class WebsocketApplicationTest {

    @LocalServerPort
    int port;

    @Test
    public void test() {
        final StompClient stompClient = new StompClient();
        stompClient.connect(port);

        stompClient.send("/app/msg", new ChatMessage("Peter", "Hi"));

        new Scanner(System.in).nextLine();
    }
}