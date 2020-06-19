package ch11.file.integration.messageendpoints;

import ch11.file.integration.data.Todo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Because this app reads from a file, it is necessary to
 * create a converter that reads a String entry, parses it,
 * and returns a new instance
 */
@Component
public class TodoConverter implements Converter<String, Todo> {

    @Override
    public Todo convert(final String source) {
        List<String> fields = Stream.of(source.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
        return new Todo(fields.get(0), Boolean.parseBoolean(fields.get(1)));
    }
}
