package ch8.overriding.basic.security.with.configuration.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/*
 * WebSecurityConfigurerAdapter - override security
 *
 * configure() method exist with different arguments:
 * - AuthenticationManagerBuilder - define users, pws, etc.
 * - HttpSecurity - define secured request urls
 * - WebSecurity
 * - AuthenticationConfiguration
 *
 */
@Configuration
public class ToDoSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * # configure in-memory authentication
     * AuthenticationManagerBuilder - creates an AuthenticationManager that allows to easily build
     * in-memory, LDAP, JDBC authentications, UserDetailsService and add AutheticationProviders
     */
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("apress")
                .password(passwordEncoder().encode("springboot2"))
                .roles("ADMIN", "USER");
    }

    /*
     * PasswordEncoder implementation to use and encrypt/decrypt the password
     *  - alternatives: Pbkdf2PasswordEncoder, SCryptPasswordEncoder, DelegatingPasswordEncoder (supports password upgrades)
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * HttpSecurity - allows to configure web-based security for specific HTTP requests
     * - by default, it is applied to all requests
     * - can be restricted using requestMatcher
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll() // common locations, such as the static resources (static/* ) where CSS, JS, or any other simple HTML can live and doesn’t need any security.
                .anyRequest().fullyAuthenticated() // /api/* should be fullyAuthenticated
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and().httpBasic(); // allows non-browser clients like cURL
    }
}
