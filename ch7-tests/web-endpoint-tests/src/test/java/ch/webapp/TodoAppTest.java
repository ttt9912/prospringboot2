package ch.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @RunWith - wires up framework goodies
 *
 * @ContextConfiguration - must-have to load and configure ApplicationContext
 * provide location of config xml files or Configuration classes
 *
 * @ActiveProfiles - declare which bean definition profiles should be used when loading
 * an ApplicationContext for test classes.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TodoApp.class)
@ActiveProfiles("dev")
public class TodoAppTest {

    @Test
    public void contextLoads() {
    }
}