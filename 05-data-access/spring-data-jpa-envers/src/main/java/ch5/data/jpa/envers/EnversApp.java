package ch5.data.jpa.envers;

import ch5.data.jpa.envers.data.Book;
import ch5.data.jpa.envers.data.BookRepository;
import ch5.data.jpa.envers.data.Person;
import ch5.data.jpa.envers.data.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * ---------------------------------------------------
 * All Persons
 * ---------------------------------------------------
 * http://localhost:8080/api/persons
 *
 * ---------------------------------------------------
 * Person by Id (current version)
 * ---------------------------------------------------
 * http://localhost:8080/api/persons/1111
 *
 * ---------------------------------------------------
 * Person by Id (all versions)
 * ---------------------------------------------------
 * http://localhost:8080/api/persons/1111/versions
 */
@SpringBootApplication
public class EnversApp {

    public static void main(String[] args) {
        SpringApplication.run(EnversApp.class, args);
    }

    @Bean
    public CommandLineRunner run(
            PersonRepository personRepository,
            BookRepository bookRepository
    ) {
        return args -> {
            personRepository.save(new Person("1111", "Peter", "Griffin"));
            personRepository.save(new Person("1111", "Peterson", "Griffin"));

            bookRepository.save(new Book("1234", "Homo Faber", "Max Fritsch"));
            bookRepository.save(new Book("1234", "Homo Faber", "Max Frisch"));
        };
    }
}
