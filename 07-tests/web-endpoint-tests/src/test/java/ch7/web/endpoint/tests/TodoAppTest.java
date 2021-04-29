package ch7.web.endpoint.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * @RunWith - wires up framework goodies
 *
 * @ContextConfiguration - must-have to load and configure ApplicationContext
 * provide location of config xml files or Configuration classes
 *
 * @ActiveProfiles - declare which bean definition profiles should be used when loading
 * an ApplicationContext for test classes.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TodoApp.class)
@ActiveProfiles("dev")
public class TodoAppTest {

    @Test
    public void contextLoads() {
    }
}
