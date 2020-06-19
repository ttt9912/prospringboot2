package ch4.server.service;

import ch4.server.data.ToDo;
import ch4.server.data.ToDoRepository;
import ch4.server.validation.ToDoValidationError;
import ch4.server.validation.ToDoValidationErrorBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;

/*
 * # Rest API Guidelines
 * - resource name in plural
 *
 * # spring web bind annotations
 * @PathVariable - <url>?id=1
 * @RequestParam - <url>/{id}/
 * @RequestBody - HttpMessageConverter deserializes JSON to an instance
 *
 * @ResponseStatus - usually on void methods, returns status code
 * @ResponseBody - HTTP response body
 * ResponseEntity - Returns a full HTTP response including status, headers & body
 */
@RestController
@RequestMapping("/api")
public class TodoController {
    private final ToDoRepository repository;

    public TodoController(final ToDoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public ResponseEntity<Collection<ToDo>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    /*
     * PATCH
     * can be used to update partial resources
     * for instance, when you only need to update one field of the resource
     * PUTting a complete resource representation might be cumbersome and utilizes more bandwidth
     */
    @PatchMapping("/todos/{id}")
    public ResponseEntity<ToDo> setCompleted(@PathVariable String id) {
        ToDo toDo = repository.findById(id);
        toDo.setCompleted(true);
        repository.save(toDo);

        // Redirect client
        // Location - HTTP Response header field
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().buildAndExpand(toDo.getId()).toUri();
        return ResponseEntity.ok().header("Location", location.toString()).build();
    }

    /*
     * Use same method to handle HTTP POST & PUT
     * @Valid - Validates incoming data, triggers validator
     */
    @RequestMapping(value = "/todos", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<?> create(@Valid @RequestBody ToDo toDo, Errors validationErrors) {
        if (validationErrors.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body(ToDoValidationErrorBuilder.fromBindingErrors(validationErrors));
        }
        ToDo saved = repository.save(toDo);

        // Redirect
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<ToDo> delete(@PathVariable String id) {
        repository.delete(repository.findById(id));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<ToDo> delete(@RequestBody ToDo toDo) {
        repository.delete(toDo);
        return ResponseEntity.noContent().build();
    }

    /*
     * @ExceptionHandler - any exception is redirected here
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ToDoValidationError handleException(Exception exception) {
        return new ToDoValidationError(exception.getMessage());
    }
}
