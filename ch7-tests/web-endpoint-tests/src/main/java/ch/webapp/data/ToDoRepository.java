package ch.webapp.data;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ToDoRepository {

    public List<ToDo> findAll() {
        return Arrays.asList(
                createToDo("feed dog"),
                createToDo("go walk"));
    }

    ToDo createToDo(final String description) {
        final LocalDateTime now = LocalDateTime.now();
        return new ToDo(UUID.randomUUID().toString(),
                description, now, now, false);
    }
}
