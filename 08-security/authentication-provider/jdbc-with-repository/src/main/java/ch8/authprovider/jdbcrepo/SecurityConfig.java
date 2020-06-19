package ch8.authprovider.jdbcrepo;

import ch8.authprovider.jdbcrepo.useraccount.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * provide an implementation of UserDetailsService
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserAccountService userAccountService;

    /*
     * - Spring boot login page
     * - free access to /h2-console
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().fullyAuthenticated()
                .and().csrf().ignoringAntMatchers("/h2-console/**") // H2: don't apply CSRF protection to /h2-console
                .and().headers().frameOptions().sameOrigin() // H2: allow use of frame to same origin urls
                .and().formLogin();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userAccountService);
    }
}
