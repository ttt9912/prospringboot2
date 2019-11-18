package ch7.web.endpoint.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * ---------------------------------------------------------------------------------
 * Mocking the web layer
 * ---------------------------------------------------------------------------------
 *
 * @AutoConfigureMockMvc - sets up a mock environment (MockMvc class)
 *
 * # MockMvc
 * perform() - returns ResultActions instance which allows chaining (andExpect(), andDo(), andReturn())
 * andExpect() - takes an ResultMatcher implementation (i.e. MockMvcResultMatchers) as argument
 * andDo() - takes an ResultHandler implementation (i.e. MockMvcResultHandlers)
 * andReturn() - returns the MvcResult
 */
@RunWith(SpringRunner.class)
@SpringBootTest // default WebEnvironment = MOCK
@AutoConfigureMockMvc
public class MockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    // andExpect() demo - assert things
    @Test
    public void getToDos_andExpect() throws Exception {
        this.mockMvc
                .perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    // andDo() demo - do something with the result
    @Test
    public void getToDos_andDo() throws Exception {
        this.mockMvc
                .perform(get("/api/todos"))
                .andDo(print());
    }

    // andReturn() demo - get the MvcResult
    @Test
    public void getToDos_andReturn() throws Exception {
        MvcResult mvcResult = this.mockMvc
                .perform(get("/api/todos"))
                .andReturn();

        assertEquals(MediaType.APPLICATION_JSON.toString(), mvcResult.getResponse().getContentType());
    }
}