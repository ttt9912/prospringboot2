package jdbc.person.directory.config;

import jdbc.person.directory.data.PersonRepository;
import jdbc.person.directory.security.DirectoryUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * WebSecurityConfigurerAdapter - customize Spring Security
 */
@Configuration
public class DirectorySecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonRepository personRepository;

    public DirectorySecurityConfig(final PersonRepository personRepository) {
        this.personRepository = personRepository;
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
        auth.userDetailsService(
                new DirectoryUserDetailsService(this.personRepository));
    }
}
