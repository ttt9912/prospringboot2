package ch3.spring_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * # SpringApplication.run()
 * returns ConfigurableApplicationContext
 *
 * # SpringApplication instance
 * Instead of calling static SpringApplication.run(), an instance
 * of SpringApplication can be created - allows additional configuration
 *
 */
@SpringBootApplication
public class SpringApplicationDemo {

    // SpringApplication features
    public static void main(String[] args) {
        final SpringApplication springApplication = new SpringApplication(SpringApplicationDemo.class);

        // set custom banner
        springApplication.setBanner((environment, sourceClass, out) -> out.println("MY BANNER"));

        // get/set WebApplicationType
        System.out.println(springApplication.getWebApplicationType());

        // etc..

        springApplication
                .run(args)
                .close();
    }
}
