package todoapp.data;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository {
    private final Map<String, ToDo> toDoCache = new HashMap<>();

    @PostConstruct
    private void init() {
        ToDo todo1 = new ToDo("Feed Dog");
        ToDo todo2 = new ToDo("Call Grandmother");
        toDoCache.put(todo1.getId(), todo1);
        toDoCache.put(todo2.getId(), todo2);
    }

    public Collection<ToDo> findAll() {
        return toDoCache.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparing(ToDo::getCreated))
                .collect(Collectors.toList());
    }

    public ToDo findById(final String id) {
        return toDoCache.get(id);
    }

    // create or update
    public ToDo save(final ToDo toDo) {
        final ToDo existing = toDoCache.get(toDo.getId());
        if (existing == null) {
            toDoCache.put(toDo.getId(), toDo);
            return toDo;
        }
        existing.setDescription(toDo.getDescription());
        existing.setModified(LocalDateTime.now());
        existing.setCompleted(toDo.getCompleted());
        return existing;
    }

    public Collection<ToDo> saveAll(final Collection<ToDo> toDos) {
        toDos.forEach(this::save);
        return findAll();
    }

    public void delete(ToDo toDo) {
        toDoCache.remove(toDo);
    }

}
