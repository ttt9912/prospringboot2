package ch8.authprovider.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;

import static org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2;

/*
 * Spring Security provides default queries for JDBC based authentication.
 *
 * spring users.ddl script creates Tables USERS and AUTHORITIES to store
 * authentication information
 */
@Configuration
public class JdbcConfig {

    /*
     * init Spring Security default schema
     */
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(H2)
                .addScript("classpath:org/springframework/security/core/userdetails/jdbc/users.ddl")
                .build();
    }
}
