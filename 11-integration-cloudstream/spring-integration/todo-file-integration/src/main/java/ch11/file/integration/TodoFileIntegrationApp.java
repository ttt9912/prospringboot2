package ch11.file.integration;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * Integration Flow
 * ---------------------------------------------------------------------------------
 * - reads a text file
 * - converts content to an instance
 * - logs instance
 *
 * ---------------------------------------------------------------------------------
 * Run
 * ---------------------------------------------------------------------------------
 * - create list.txt under /Users/ttt/dev/temp
 * - list.txt content:
 *      buy milk today, true
 *      read a book, false
 */
@SpringBootApplication
public class TodoFileIntegrationApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoFileIntegrationApp.class, args);
    }
}
