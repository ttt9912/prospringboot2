package ch8.rememberme;

import common.todo.rest.CommonTodoRestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/*
 * RememberMe - identify the user across multiple sessions
 *
 * Additional Cookie is set at login (Header)
 *  'Set-Cookie: remember-me=UGF1bDoxNTmOGNlYmIx; Max-Age=86400; Expires=Tue, 21-Apr-2020 20:42:06 GMT; Path=/; HttpOnly'
 *
 * ------------------------------------------
 * remember-me Cookie
 * ------------------------------------------
 * contains MD5 hash of:
 * - username
 * - password
 * - expirationTime
 * - expirationTime
 * - key (private key to prevent modification of the remember-me token)
 *
 * ------------------------------------------
 * Vulnerability
 * ------------------------------------------
 * if the remember me cookie is capture, it will be valid and
 * usable until it expires or the credentials are changed.
 *
 * ------------------------------------------
 * Browser
 * ------------------------------------------
 * - log in with remember me active
 * - wait for the session to expire (or remove the JSESSIONID cookie in the browser)
 * - refresh the page
 *
 */
@SpringBootApplication
@Import(CommonTodoRestConfig.class)
public class RememberMeApp {

    public static void main(String[] args) {
        SpringApplication.run(RememberMeApp.class, args);
    }
}
