package ch.webapp;

import ch.webapp.data.ToDo;
import org.assertj.core.util.Files;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * @JsonTest - helps with serialization/deserialization
 * - auto configures the supported json mapper based on the classpath (jackson, gson, jsonb)
 *
 * isEqualToJson() - provide file, stream, or body
 */
@RunWith(SpringRunner.class)
@JsonTest
public class JsonTestTest {

    @Autowired
    private JacksonTester<ToDo> json;

    @Test
    public void serializeTodos() throws IOException {
        ToDo toDo = new ToDo("id1", "read book", null, null, false);

        assertThat(json.write(toDo)).isEqualToJson(new ClassPathResource("read-book.json"));

        assertThat(json.write(toDo)).hasJsonPathStringValue("@.description");

        assertThat(json.write(toDo)).extractingJsonPathStringValue("@.description")
                .isEqualTo("read book");
    }

    @Test
    public void deserializeTodos() throws IOException {
        File file = new ClassPathResource("read-book.json").getFile();
        String content = Files.contentOf(file, Charset.defaultCharset());

        assertThat(json.parse(content))
                .isEqualTo(new ToDo("id1", "read book", null, null, false));

        assertThat(json.parseObject(content).getDescription()).isEqualTo("read book");
    }
}
