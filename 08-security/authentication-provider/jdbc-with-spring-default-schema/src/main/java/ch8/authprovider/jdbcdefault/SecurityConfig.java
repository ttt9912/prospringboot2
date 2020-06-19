package ch8.authprovider.jdbcdefault;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

/*
 * Provide a bean of UserDetailsService
 * (=> JdbcDaoImpl)
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

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

    /*
     * JdbcUserDetailsManager implements JdbcDaoImpl
     */
    @Bean
    public UserDetailsService users(DataSource dataSource) {
        final UserDetails user = User.builder()
                .username("user")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER")
                .build();
        final UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW")
                .roles("USER", "ADMIN")
                .build();

        final JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }
}
