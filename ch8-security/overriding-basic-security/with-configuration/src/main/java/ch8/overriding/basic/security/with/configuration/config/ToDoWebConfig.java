package ch8.overriding.basic.security.with.configuration.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * tell Spring MVC how to locate the custom login page
 */
@Configuration
public class ToDoWebConfig implements WebMvcConfigurer {

    // This locates the templates/login.mustache page
    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
