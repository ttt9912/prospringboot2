package todoclient.data;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

@Service
public class ToDoService {
    private final Map<String, ToDo> toDoCache = new HashMap<>();

    private Map<String, ToDo> cache;

    public ToDoService() {
        cache = new HashMap<>();
        cache.put("id-1", new ToDo("id-1", "feed dog", now(), now(), false));
        cache.put("id-2", new ToDo("id-2", "go walk", now(), now(), false));
    }

    public List<ToDo> findAll() {
        return new ArrayList<>(cache.values());
    }

    public ToDo findById(final String id) {
        return cache.get(id);
    }

    public void save(final ToDo toDo) {
        cache.put(toDo.getId(), toDo);
    }

}
