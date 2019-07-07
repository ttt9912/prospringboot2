package ch6.webflux.webflux;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/*
 * WebFlux Provides two programming models
 * - Annotated Controllers
 * - Functional endpoints (RouterFunction)
 *
 * WebFlux uses Netty as primary container
 * override with @Configuration class of type WebFluxConfigurer
 *
 * Filters, exception handlers CORS, view technologies and security
 * are handled same as in Spring MVC
 *
 * WebClient - reactive, non-blocking client for HTTP requests
 */
@SpringBootApplication
public class WebfluxApp {

    /*
     * Spring Boot auto configures Spring MVC - REACTIVE web application type must be set
     */
    public static void main(String[] args) {
        new SpringApplicationBuilder(WebfluxApp.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }
}
