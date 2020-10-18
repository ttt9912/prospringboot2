package rsocket.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


/*
 * Sets up an RSocket
 *
 * -------------------------------
 * CLI client (curl for RSocket)
 * -------------------------------
 * https://github.com/making/rsc
 *
 * $ java -jar rsc-0.5.0.jar tcp://localhost:8888 --stream --route greetings --log --debug -d "{\"name\" : \"Josh\"}"
 *
 * (run in directory /rsocket, where rsc jar is located)
 *
 */
@SpringBootApplication
public class RSocketReactiveApp {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RSocketReactiveApp.class, args);
    }
}
