package ch8.authprovider.jdbcdirectory.todoapp;

import ch8.authprovider.jdbcdirectory.todoapp.security.PersonUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * AuthenticationManager is configured to provide a UserDetails instance by
 * calling the directory app using RestTemplate (PersonDirectoryService).
 */
@Slf4j
@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonUserDetailsService personUserDetailsService;

    public ToDoSecurityConfig(final PersonUserDetailsService personUserDetailsService) {
        this.personUserDetailsService = personUserDetailsService;
    }

    /*
     * provide an UserDetailsService implementation
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personUserDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/api/**").hasRole("USER")
                .and()
                .httpBasic();
    }
}
