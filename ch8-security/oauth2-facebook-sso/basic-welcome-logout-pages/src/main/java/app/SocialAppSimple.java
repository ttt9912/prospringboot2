package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * ---------------------------------------------------------------------------------
 * Login
 * ---------------------------------------------------------------------------------
 * - spring exposes /login endpoint
 * Instead of being redirected immediately, the new link will be visible on the
 * home page, and the user can choose to login or to stay unauthenticated
 *
 * ---------------------------------------------------------------------------------
 * Logout
 * ---------------------------------------------------------------------------------
 * - spring exposes /logout endpoint (configured in SecurityConfig)
 * logging out requires a state change - transforming the app from a read-only
 * resource to a read-write one
 * - POST request with csrf token on /logout
 */
@SpringBootApplication
public class SocialAppSimple {
    public static void main(String[] args) {
        SpringApplication.run(SocialAppSimple.class, args);
    }
}
