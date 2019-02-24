package ch.webapp;

import ch.webapp.data.ToDo;
import ch.webapp.data.ToDoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/*
 * @MockBean - defines a Mockito Mock for a bean inside the ApplicationContext
 * Mock a new bean or replace an existing.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MockBeanTest {

    @MockBean
    private ToDoRepository repository;

    private List<ToDo> mockData = Collections.singletonList(new ToDo("id1", "read book", null, null, false));

    @Test
    public void getToDos() {
        given(repository.findAll()).willReturn(mockData);

        assertThat(repository.findAll()).hasSize(1);
        assertThat(repository.findAll().get(0))
                .extracting(ToDo::getDescription).isEqualTo("wash car");
    }
}
