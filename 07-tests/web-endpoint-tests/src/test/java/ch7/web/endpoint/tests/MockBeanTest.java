package ch7.web.endpoint.tests;

import ch7.web.endpoint.tests.data.ToDo;
import ch7.web.endpoint.tests.data.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/*
 * @MockBean - defines a Mockito Mock for a bean inside the ApplicationContext
 * Mock a new bean or replace an existing.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MockBeanTest {

    @MockBean
    private ToDoService repository;

    private List<ToDo> mockData = Collections.singletonList(new ToDo("id1", "read book", null, null, false));

    @Test
    public void getToDos() {
        given(repository.findAll()).willReturn(mockData);

        assertThat(repository.findAll()).hasSize(1);
        assertThat(repository.findAll().get(0))
                .extracting(ToDo::getDescription).isEqualTo("read book");
    }
}
