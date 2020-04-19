package ch8.auth.httpbasic;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * https://docs.spring.io/spring-security/site/docs/5.3.2.BUILD-SNAPSHOT/reference/html5/#servlet-authentication-basic
 *
 *
 * -----------------------------------------------------------------------------
 * Authorization Header
 * -----------------------------------------------------------------------------
 * username and password being provided through Authorization Header
 *
 * every request contains Authorization Header
 *      'Authorization: Basic dXNlcjoyMDFkYjgwNy1hNmY5LTRiMDQtYmE4OS1jMmE4MjE5YjgzYjU='
 *
 * -----------------------------------------------------------------------------
 * WWW-Authenticate Header
 * -----------------------------------------------------------------------------
 * WWW-Authenticate header is sent back to an unauthenticated client
 *
 *
 * -----------------------------------------------------------------------------
 * Browser
 * -----------------------------------------------------------------------------
 * - username/password are requested via popup and then sent with Authorization
 *   Header in every request
 *
 * localhost:8080/api/todos
 *
 * -----------------------------------------------------------------------------
 * curl
 * -----------------------------------------------------------------------------
 * first response will return Set-Cookie with JSESSIONID which saves the
 * authentication
 *
 * # First Request (provide credentials)
 * $ curl -v localhost:8080/api/todos -u user:<password>
 *
 * # Subsequent Requests (provide Authorization Header or Session cookie)
 * $ curl -v localhost:8080/api/todos -H "Authorization: Basic <token>"
 * $ curl -v localhost:8080/api/todos -H "Cookie: JSESSIONID=<session-id>"
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class HttpBasicApp {

    public static void main(String[] args) {
        SpringApplication.run(HttpBasicApp.class, args);
    }

}
