package jdbcapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
 */
@SpringBootApplication
public class JdbcApp {
    public static void main(String[] args) {
        SpringApplication.run(JdbcApp.class, args)
                .close();
    }

}
