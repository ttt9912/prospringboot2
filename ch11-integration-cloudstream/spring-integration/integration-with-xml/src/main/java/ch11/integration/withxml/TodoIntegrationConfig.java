package ch11.integration.withxml;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@EnableIntegration
@Configuration
@ImportResource("META-INF/spring/integration/todo-context.xml")
public class TodoIntegrationConfig {

}
