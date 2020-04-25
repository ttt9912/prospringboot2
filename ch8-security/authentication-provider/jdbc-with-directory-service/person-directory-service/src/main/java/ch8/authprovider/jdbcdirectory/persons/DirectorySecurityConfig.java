package ch8.authprovider.jdbcdirectory.persons;

import ch8.authprovider.jdbcdirectory.persons.security.PersonUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * WebSecurityConfigurerAdapter - customize Spring Security
 */
@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonUserDetailsService personUserDetailsService;

    public DirectorySecurityConfig(final PersonUserDetailsService personUserDetailsService) {
        this.personUserDetailsService = personUserDetailsService;
    }

    /*
     * define authorized requests
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                .and().httpBasic();
    }

    /*
     * configure users with UserDetailService implementation (instead of in-memory)
     * UserDetailService - key to using any third-party security app
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personUserDetailsService);
    }
}
