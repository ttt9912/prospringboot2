package jdbcapp;

import jdbcapp.data.ToDo;
import jdbcapp.data.ToDoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

/*
 * @JdbcTest
 * - auto-configures in-memory database
 * - JdbcTemplate
 *
 *
 */
@RunWith(SpringRunner.class)
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

        assertThat(toDoRepository.findById(todo.getId())).isEqualTo(todo);
    }
}