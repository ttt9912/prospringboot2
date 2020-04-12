package ch9.simpsendtouser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * open localhost:8080 in two browsers
 *  login as Peter:123 and Paul:123
 */
@SpringBootApplication
public class UserChatApp {

    public static void main(String[] args) {
        SpringApplication.run(UserChatApp.class, args);
    }
}
