package ch8.securitycontext;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.event.EventListener;
import org.springframework.security.access.event.AuthorizationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.support.ServletRequestHandledEvent;

/*
 * -----------------------------------------------------------------------------
 * SecurityContextHolder
 * -----------------------------------------------------------------------------
 * is where Spring Security stores the details of who is authenticated
 * contains SecurityContext
 *
 * -----------------------------------------------------------------------------
 * SecurityContext
 * -----------------------------------------------------------------------------
 * contains Authentication of the current Thread
 *
 * -----------------------------------------------------------------------------
 * Authentication
 * -----------------------------------------------------------------------------
 * represents Principal, Credentials and Authorities of an authenticated user
 *
 *
 * go to localhost:8080/api/todos
 *
 * Logins
 * - Peter:123  (ADMIN)
 * - Paul:123   (USER)
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class TodoApp {

    public static void main(String[] args) {
        SpringApplication.run(TodoApp.class, args);
    }

    @EventListener(ServletRequestHandledEvent.class)
    public void handle(ServletRequestHandledEvent event) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("--- SecurityContext - Authentication ---");
        System.out.println("- Principal: " + authentication.getPrincipal());
        System.out.println("- Credentials: " + authentication.getCredentials());
        System.out.println("- Authorities: " + authentication.getAuthorities());
        System.out.println("- is authenticated: " + authentication.isAuthenticated());
    }

    @EventListener(AuthorizationFailureEvent.class)
    public void handle(AuthorizationFailureEvent event) {
        System.out.println(">>  " + event.getClass().getSimpleName());
    }

    @EventListener(AuthenticationSuccessEvent.class)
    public void handle(AuthenticationSuccessEvent event) {
        System.out.println(">> " + event.getClass().getSimpleName() + " " + event.getAuthentication());
    }

}
