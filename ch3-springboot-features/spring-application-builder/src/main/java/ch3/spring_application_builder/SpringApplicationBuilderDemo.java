package ch3.spring_application_builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/*
 * Fluent API for SpringApplication and ApplicationContext
 *
 * # WebApplicationType
 * - SERVLET, REACTIVE - web apps
 * - NONE - non-web spring app
 */
@SpringBootApplication
public class SpringApplicationBuilderDemo {
    private static final Logger log = LoggerFactory.getLogger(SpringApplicationBuilderDemo.class);


    public static void main(String[] args) {
        ApplicationListener<ApplicationEvent> applicationEventApplicationListener = applicationEvent -> {
            log.info("### > {}", applicationEvent.getClass().getCanonicalName());
        };

        new SpringApplicationBuilder()
                .sources(SpringApplicationBuilderDemo.class)
                .profiles("dev", "local") // activate profiles
                .listeners(applicationEventApplicationListener) // attach listeners for ApplicationEvent events
                .web(WebApplicationType.NONE) // non-web spring app
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }
}


