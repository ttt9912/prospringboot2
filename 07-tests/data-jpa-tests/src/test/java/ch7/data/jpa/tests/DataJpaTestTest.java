package ch7.data.jpa.tests;

import common.todo.data.jpa.todo.Todo;
import common.todo.data.jpa.todo.TodoRepository;
import common.todo.data.jpa.util.RepositoryUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * @DataJpaTest
 * - auto-configures in-memory db
 * - scans @Entity & Repository implementations
 * - ignores @Component
 * - provides TestEntityManager
 */
@ExtendWith(SpringExtension.class)
@DataJpaTest
// @AutoConfigureTestDatabase(replace = NONE) // test with a real database
public class DataJpaTestTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TodoRepository repository;

    @Test
    public void dataJpaTest() {
        em.merge(new Todo("drink water"));

        List<Todo> todos = RepositoryUtil.toList(repository.findAll());

        assertThat(todos).extracting(Todo::getDescription).contains("drink water");
    }
}
