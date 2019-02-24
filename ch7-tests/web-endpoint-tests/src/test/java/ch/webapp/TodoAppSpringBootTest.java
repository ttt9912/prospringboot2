package ch.webapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @SpringBootTest
 * - same package structure as configuration is required,
 *   otherwise @ContextConfiguration must be used
 * - provides useful web parameters (RANDOM_PORT, etc.)
 *
 * Default WebEnvironment: MOCK
 * - Creates a WebApplicationContext with a mock servlet environment
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoAppSpringBootTest {

    @Test
    public void contextLoads() {
    }
}