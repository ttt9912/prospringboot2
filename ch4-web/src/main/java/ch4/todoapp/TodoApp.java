package ch4.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * CURL Tests
 * -d JSON Data
 * -H Header
 *
 * # get all
 * > curl -i http://localhost:8080/api/todos
 *
 * # create new
 * > curl -i -X POST -H "Content-Type: application/json" -d '{"description":"Buy Milk"}' http://localhost:8080/api/todos
 * returns the location url of the new created entity
 *
 * # update existing
 * > curl -i -X PUT -H "Content-Type: application/json" -d '{"description":"Read Book", "id:<existingId>"}' http://localhost:8080/api/todos
 * - handled by same method as POST
 * - id is provided in the request body
 *
 * # patch completed field
 * curl -i -X PATCH http://localhost:8080/api/todos/<existingId>
 */
@SpringBootApplication
public class TodoApp {
    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }
}
