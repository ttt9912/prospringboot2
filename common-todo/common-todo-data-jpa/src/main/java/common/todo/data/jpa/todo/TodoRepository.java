package common.todo.data.jpa.todo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, String> {
    List<Todo> findByDescriptionContaining(String param);
}
