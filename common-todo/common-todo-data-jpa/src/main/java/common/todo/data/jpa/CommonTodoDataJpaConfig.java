package common.todo.data.jpa;

import common.todo.data.jpa.todo.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * - Sets up a H2 DB
 * - populates data from /resources/data.sql
 *
 * ---------------------------------------------------------------------------------
 * @EnableAutoConfiguration
 * ---------------------------------------------------------------------------------
 * - used so that @Components will be picked up from @ComponentScan
 * - this is a different situation since @SpringBootApplication is in another maven module
 * - without @EnableAutoConfiguration, there will be no TodoRepository bean and no Entities
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("classpath:common-todo-data-jpa.properties")
@Slf4j
public class CommonTodoDataJpaConfig {

    @Bean
    CommandLineRunner logInsertedTodos(TodoRepository toDoRepository) {
        return args -> {
            log.trace("inserted ToDos {}", toDoRepository.findAll());
            log.trace("Todos containing 'Buy': {}", toDoRepository.findByDescriptionContaining("Buy"));
        };
    }
}
