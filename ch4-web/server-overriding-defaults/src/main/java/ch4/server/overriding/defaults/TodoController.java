package ch4.server.overriding.defaults;

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
    private List<ToDo> todos = Arrays.asList(new ToDo("Go Walk"), new ToDo("Feed Bird"));


    @GetMapping("/todos")
    public ResponseEntity<Collection<ToDo>> getAll() {
        return ResponseEntity.ok(todos);
    }
}
