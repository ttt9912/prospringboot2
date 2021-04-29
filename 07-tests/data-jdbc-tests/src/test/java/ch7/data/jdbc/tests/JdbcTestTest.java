package ch7.data.jdbc.tests;

import ch7.data.jdbc.tests.data.ToDo;
import ch7.data.jdbc.tests.data.ToDoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * @JdbcTest
 * - auto-configures in-memory database
 * - JdbcTemplate
 */
@ExtendWith(SpringExtension.class)
@JdbcTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class JdbcTestTest {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    public void jdbcTest() {
        final ToDoRepository toDoRepository = new ToDoRepository(jdbcTemplate);

        ToDo todo = new ToDo("1a", "read book", now(), now(), false);
        toDoRepository.save(todo);

        final ToDo saved = toDoRepository.findById(todo.getId());
        assertThat(saved.getId()).isEqualTo(todo.getId());
    }
}
