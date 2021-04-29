package ch7.web.endpoint.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/*
 * @SpringBootTest
 * - same package structure as configuration is required,
 *   otherwise @ContextConfiguration must be used
 * - provides useful web parameters (RANDOM_PORT, etc.)
 *
 * Default WebEnvironment: MOCK
 * - Creates a WebApplicationContext with a mock servlet environment
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TodoAppSpringBootTest {

    @Test
    public void contextLoads() {
    }
}
