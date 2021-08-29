package caching.service;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServiceApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApp.class)
                .properties("server.port=13999")
                .run(args);
    }

}
