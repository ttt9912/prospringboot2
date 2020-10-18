package ch5.springjdbc;

import ch5.springjdbc.data.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/*
 * ---------------------------------------------------------------------------------
 *  Spring JDBC Auto Configuration
 * ---------------------------------------------------------------------------------
 * if JDBC jars are on the classpath, spring boot auto-configures sensible defaults
 *
 * # Datasource
 * - if no DataSource bean is configured, spring boot auto-configures DataSource
 *   based on the SQL drivers (H2, MySql)
 * - if an embedded engine (H2) is on the classpath, it is taken by default
 *
 * # Connection pool manager
 * HikariCP is auto-configured by default
 *
 * ---------------------------------------------------------------------------------
 * Configure Datasource
 * ---------------------------------------------------------------------------------
 * spring.datasource.username=springboot
 * spring.datasource.password=rocks!
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * spring.datasource.url=jdbc:mysql://localhost:3306/testdb?autoReconnect=true&useSSL=false
 *
 * ---------------------------------------------------------------------------------
 * DB initialization
 * ---------------------------------------------------------------------------------
 * schema.sql, data.sql are executed automatically if present on the classpath
 *
 * ---------------------------------------------------------------------------------
 * H2 Console
 * ---------------------------------------------------------------------------------
 * - spring.h2.console.enabled=true
 *
 * - http://localhost:8080/h2-console
 *      -> URL = jdbc:h2:mem:testdb (important)
 *
 * ---------------------------------------------------------------------------------
 * Log JDBC SQL
 * ---------------------------------------------------------------------------------
 * logging.level.org.springframework.data=INFO
 * logging.level.org.springframework.jdbc.core.JdbcTemplate=DEBUG
 */
@SpringBootApplication
public class JdbcApp {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class, args);
    }

    @Bean
    CommandLineRunner getInfo(DataSource dataSource) {
        return args -> System.out.println("# Datasource info: " + dataSource.getConnection());
    }

    @Bean
    CommandLineRunner getData(ToDoRepository repository) {
        return args -> System.out.println("# ToDos: " + repository.findAll());
    }
}
