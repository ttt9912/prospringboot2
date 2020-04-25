package ch8.rememberme;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /*
     * key - private key to prevent modification of the remember-me token
     *
     * tokenValiditySeconds (optional) - time the token is valid,
     *                                   default = 2 weeks
     *
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated().and()
                .formLogin().and()
                .logout().deleteCookies("JSESSIONID").and()
                .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Peter").password("{noop}123").roles("ADMIN").and()
                .withUser("Paul").password("{noop}123").roles("USER");
    }
}
