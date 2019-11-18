package keycloacksso;

import common.todo.data.rest.CommonTodoDataRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 *
 * --------------------------------------------------------
 * Keycloack docker
 * --------------------------------------------------------
 * - Admin Console: http://localhost:8180/auth/
 */
@Import(CommonTodoDataRestConfig.class)
@SpringBootApplication
public class KeycloackSSOApp {

    public static void main(String[] args) {
        SpringApplication.run(KeycloackSSOApp.class, args);
    }

}
