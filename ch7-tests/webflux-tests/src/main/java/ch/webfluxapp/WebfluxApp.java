package ch.webfluxapp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class WebfluxApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(WebfluxApp.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
