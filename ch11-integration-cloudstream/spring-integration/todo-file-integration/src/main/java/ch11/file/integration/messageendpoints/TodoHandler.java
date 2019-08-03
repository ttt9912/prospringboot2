package ch11.file.integration.messageendpoints;

import ch11.file.integration.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoHandler {

    public void process(Todo todo) {
        log.info(">>> {}", todo);
    }
}
