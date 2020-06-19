package ch7.mongo.tests;

import ch7.mongo.tests.data.ToDo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/*
 * @DataMongoTest
 * - auto-configures embedded Mongo server
 */
@RunWith(SpringRunner.class)
@DataMongoTest // (excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class) // testing without embedded server
public class DataMongoTestTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void dataMongoTest() {
        final ToDo todo = new ToDo("1a", "feed dog", LocalDateTime.now(), LocalDateTime.now(), false);
        mongoTemplate.save(todo);

        final ToDo retrieved = mongoTemplate.findById(todo.getId(), ToDo.class);

        assertNotNull(retrieved);
        assertThat(retrieved.getDescription()).isEqualTo(todo.getDescription());
    }

}