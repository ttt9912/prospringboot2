package oauth2.github.app;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * ---------------------------------------------------------------------------------
 * 1) Create new OAuth Application on GitHub
 * ---------------------------------------------------------------------------------
 * - https://github.com/settings/applications/new
 * - GitHub creates the key the application needs
 *
 * # Authorization callback URL
 * - http://localhost:8080/login/oauth2/code/github
 * - OAuth2LoginAuthenticationFilter expects to work with this endpoint pattern:
 *      /login/ oauth2/code/*;
 * - pattern is customizable by using the redirect-uri-template property
 *
 * ---------------------------------------------------------------------------------
 * 2) application.properties
 * ---------------------------------------------------------------------------------
 * copy the client id and client secret keys from GitHub and append them to the
 * application.properties
 *
 * ---------------------------------------------------------------------------------
 * Login
 * ---------------------------------------------------------------------------------
 * - http://localhost:8080
 * - redirects to GitHub, sign in with GitHub account
 * - redirects back to http://localhost:8080
 *
 */
@SpringBootApplication
@Import(CommonTodoDataRestConfig.class)
public class ToDoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoApplication.class, args);
    }
}
