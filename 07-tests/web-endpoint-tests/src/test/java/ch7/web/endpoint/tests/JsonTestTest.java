package ch7.web.endpoint.tests;

import ch7.web.endpoint.tests.data.ToDo;
import ch7.web.endpoint.tests.util.FileAsStringReader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * @JsonTest - helps with serialization/deserialization
 * - auto configures the supported json mapper based on the classpath (jackson, gson, jsonb)
 *
 * isEqualToJson() - provide file, stream, or body
 */
@ExtendWith(SpringExtension.class)
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
        String content = FileAsStringReader.readFile("read-book.json");

        assertThat(json.parse(content))
                .isEqualTo(new ToDo("id1", "read book", null, null, false));

        assertThat(json.parseObject(content).getDescription()).isEqualTo("read book");
    }
}
