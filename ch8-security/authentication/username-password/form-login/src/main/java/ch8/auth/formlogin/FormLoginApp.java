package ch8.auth.formlogin;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * https://docs.spring.io/spring-security/site/docs/5.3.2.BUILD-SNAPSHOT/reference/html5/#servlet-authentication-form
 *
 * username and password being provided through an html form
 *
 * go to localhost:8080/api/todos
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class FormLoginApp {

    public static void main(String[] args) {
        SpringApplication.run(FormLoginApp.class, args);
    }
}
