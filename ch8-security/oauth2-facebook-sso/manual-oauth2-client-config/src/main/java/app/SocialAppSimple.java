package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * picking apart the "magic" in the @EnableOAuth2Sso annotation,
 * manually configuring everything in there to make it explicit
 *
 * ---------------------------------------------------------------------------------
 * @EnableOAuth2Sso
 * ---------------------------------------------------------------------------------
 * 2 features:
 * - OAuth2 client (@EnableOAuth2Client)
 * - authentication
 */
@SpringBootApplication
public class SocialAppSimple {
    public static void main(String[] args) {
        SpringApplication.run(SocialAppSimple.class, args);
    }
}
