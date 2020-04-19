package ch8.authprovider.inmemory;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/*
 * Provide a bean of UserDetailsService
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * Spring boot login page
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated().and()
                .formLogin();
    }

    /*
     * inMemoryAuthentication() - provides a bean of type InMemoryUserDetailsManager
     * which implements UserDetailsService
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER", "ADMIN")
                .build();

        auth.inMemoryAuthentication()
                .withUser(user).withUser(admin);
    }

}
