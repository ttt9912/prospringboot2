package reactivedata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import reactivedata.data.ToDo;
import reactivedata.data.ToDoReactiveRepository;

/*
 * # Reactive Repositories
 * reactive wrapper types
 * - ReactiveCrudRepository
 * - ReactiveSortingRepository
 * - RxJava2CrudRepository
 * - RxJava2SortingRepository
 *
 * # Spring Data MongoDB
 * provides ReactiveMongoOperations helper to use Flux and Mono
 */
@SpringBootApplication
public class ReactiveDataApp {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ReactiveDataApp.class)
                .web(WebApplicationType.REACTIVE)
                .run(args);
    }

    @Bean
    public CommandLineRunner insertAndView(ToDoReactiveRepository repository) {
        return args -> {
            repository.save(new ToDo("do homework")).subscribe();
            repository.save(new ToDo("feed dog")).subscribe();
            repository.findAll().subscribe(System.out::println);
        };
    }
}
