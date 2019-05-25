package app;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


/*
 * make the login page visible to an unauthenticated user
 *
 * ---------------------------------------------------------------------------------
 * Logout
 * ---------------------------------------------------------------------------------
 * - logout() - spring exposes a /logout endpoint (POST)
 *   spring which will clear the session and invalidate the cookie
 *
 * Do logout from JS -> POST request on /logout
 *
 * ---------------------------------------------------------------------------------
 * Logout - CSRF
 * ---------------------------------------------------------------------------------
 * - Logout Request Body contains token to protect against CSRF
 * - value of the token is linked to the current session,
 *   which is what provides the protection
 *
 * - Many JavaScript frameworks have built in support for CSRF (Angular: XSRF)
 *
 * ---------------------------------------------------------------------------------
 * CSRF with jQuery
 * ---------------------------------------------------------------------------------
 * Since we are not using a higher level framework in this sample, we need to
 * explicitly add the CSRF token, which we made available as a cookie from the
 * backend
 */
@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/login**", "/webjars/**", "/error**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll() // logout rest endpoint
                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()); // CSRF
    }
}
