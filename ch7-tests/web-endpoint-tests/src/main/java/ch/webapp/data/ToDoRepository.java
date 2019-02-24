package ch.webapp.data;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ToDoRepository {

    public List<ToDo> findAll() {
        return Arrays.asList(
                new ToDo("feed dog"),
                new ToDo("go walk"));
    }
}
