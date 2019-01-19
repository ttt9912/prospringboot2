package overriding_defaults;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private List<String> todos = Arrays.asList("Go Walk", "Feed Bird");

    @GetMapping("/todos")
    public ResponseEntity<Collection<String>> getAll() {
        return ResponseEntity.ok(todos);
    }
}
