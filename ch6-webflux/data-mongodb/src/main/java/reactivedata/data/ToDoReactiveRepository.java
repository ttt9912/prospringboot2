package reactivedata.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/*
 * # ReactiveMongoRepository
 * - provides standard repository functionality
 * - returns Flux and Mono
 */
public interface ToDoReactiveRepository
        extends ReactiveMongoRepository<ToDo, String> {
}
