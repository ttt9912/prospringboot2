package ch.datajpaapp;

import ch.datajpaapp.data.RepositoryUtil;
import ch.datajpaapp.data.ToDo;
import ch.datajpaapp.data.ToDoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * @DataJpaTest
 * - auto-configures in-memory db
 * - scans @Entity, ignores @Component
 * - provides TestEntityManager
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class DataJpaTestTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ToDoRepository repository;

    @Test
    public void dataJpaTest() {
        em.merge(new ToDo("1a", "drink water", LocalDateTime.now(), LocalDateTime.now(), false));

        List<ToDo> toDos = RepositoryUtil.toList(repository.findAll());

        assertThat(toDos.get(0)).extracting(ToDo::getDescription).isEqualTo("drink water");
    }
}