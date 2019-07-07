package jdbc.directory.todoapp.config;

import jdbc.directory.todoapp.integration.Person;
import jdbc.directory.todoapp.integration.PersonDirectoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * AuthenticationManager is configured to provide a UserDetails instance by
 * calling the directory app using RestTemplate (PersonDirectoryService).
 */
@Slf4j
@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PersonDirectoryService personDirectoryService;

    public ToDoSecurityConfig(final PersonDirectoryService personDirectoryService) {
        this.personDirectoryService = personDirectoryService;
    }


    /*
     * provide an UserDetailsService implementation
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
                final Person person = personDirectoryService.loadPersonByEmail(username);

                if (person == null) {
                    throw new UsernameNotFoundException(username);
                }

                final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

                return User.withUsername(person.getEmail())
                        .password(encoder.encode(person.getPassword()))
                        .accountLocked(!person.isEnabled())
                        .roles(person.getRole())
                        .build();
            }
        });
    }

    /*
     * eigene login page: and().formLogin()
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers("/", "/api/**").hasRole("USER")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .httpBasic();
    }
}
