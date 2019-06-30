package common.todo.data.rest;

import common.todo.data.jpa.CommonTodoDataJpaConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/*
 * # Show exposed Endpoints
 * - http://localhost:8080/api              (entity endpoints)
 * - http://localhost:8080/api/todos/search (TodoRepository methods)
 *
 * # Exposed endpoints for Entities
 * - http://localhost:8080/api/todos      (GET/PUT/POST/DELETE)
 *
 * # Exposed endpoints Repository Methods
 * - http://localhost:8080/api/todos/search/findByDescriptionContaining?param=Buy
 *
 *
 * Optional: HAL Browser (additional dependency)
 *
 */
@Configuration
@EnableAutoConfiguration
@Import(CommonTodoDataJpaConfig.class)
@PropertySource("classpath:common-todo-data-rest.properties")
public class CommonTodoDataRestConfig {
}
