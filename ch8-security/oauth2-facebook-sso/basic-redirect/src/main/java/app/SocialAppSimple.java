package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/*
 * https://spring.io/guides/tutorials/spring-boot-oauth2/#_social_login_simple
 *
 * ---------------------------------------------------------------------------------
 * Register app on Facebook
 * ---------------------------------------------------------------------------------
 * 1. Create a new App on Facebook for Developers
 * 2. App -> Settings -> Basic
 *    - copy paste App ID & App Secret to application.yml
 *
 * ---------------------------------------------------------------------------------
 * run
 * ---------------------------------------------------------------------------------
 * 1. go to localhost:8080
 * 2. will directly redirect to Facebook to login with Facebook account
 * 3. after login, redirected to localhost:8080
 *
 */
@SpringBootApplication
@EnableOAuth2Sso // make the link to Facebook, delegate login to Facebook (OAuth2)
public class SocialAppSimple {
    public static void main(String[] args) {
        SpringApplication.run(SocialAppSimple.class, args);
    }

}
