package ch7.web.endpoint.tests;

import ch7.web.endpoint.tests.data.ToDo;
import ch7.web.endpoint.tests.data.ToDoService;
import ch7.web.endpoint.tests.service.TodoController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Limits scanned beans to @Controller, @JsonComponent, Filter, WebMvcConfigurer, etc.
 *
 * Other beans are ignored - @Component, @Repository, etc.
 *
 * If a Service is used, inject it with @MockBean
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TodoController.class)
public class WebMvcTestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService repository;


    @Test
    public void toDoControllerTest() throws Exception {
        given(repository.findAll()).willReturn(
                Collections.singletonList(new ToDo("id1", "read book", null, null, false)));

        mockMvc.perform(get("/api/todos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":\"id1\",\"description\":\"read book\",\"created\":null,\"modified\":null,\"completed\":false}]"));
    }
}
