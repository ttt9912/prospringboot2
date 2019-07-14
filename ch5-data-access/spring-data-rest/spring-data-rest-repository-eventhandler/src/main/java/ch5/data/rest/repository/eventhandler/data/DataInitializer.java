package ch5.data.rest.repository.eventhandler.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Slf4j
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner data(final ToDoRepository repository) {
        log.info("initializing Todo data...");
        ToDo toDo1 = new ToDo();
        toDo1.setDescription("feed dog");
        ToDo toDo2 = new ToDo();
        toDo2.setDescription("read book");

        return args -> repository.saveAll(Arrays.asList(toDo1, toDo2));
    }
}
