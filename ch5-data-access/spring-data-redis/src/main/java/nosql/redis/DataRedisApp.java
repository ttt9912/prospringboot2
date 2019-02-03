package nosql.redis;

import nosql.redis.data.ToDo;
import nosql.redis.data.ToDoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/*
 * ---------------------------------------------------------------------------------
 * Spring Data Redis
 * ---------------------------------------------------------------------------------
 * Redis = Key-Value database
 *
 * @EnableRedisRepositories is auto-configured
 *
 * Same model and repositories can be reused
 * with @RedisHash instead of @Entity
 *
 * ---------------------------------------------------------------------------------
 * Spring Data Redis Features
 * ---------------------------------------------------------------------------------
 * - RedisTemplate
 * - Messaging with Pub/Sub
 * - Redis Cluster support
 * - @EnableRedisRepositories - repositories, sorting, paging
 *
 * Redis implements Spring cache and can be used as web cache
 *
 * ---------------------------------------------------------------------------------
 * Redis Server
 * ---------------------------------------------------------------------------------
 * default port: 6379
 * override defaults, set connection properties: spring.redis.* properties
 *
 * ---------------------------------------------------------------------------------
 * Redis Embedded server
 * ---------------------------------------------------------------------------------
 * - maven dependency
 * - set spring.redis.* connection properties
 * - setup embedded redis component
 */
@SpringBootApplication
public class DataRedisApp {
    public static void main(String[] args) {
        SpringApplication.run(DataRedisApp.class, args);
    }

    @Bean
    CommandLineRunner init(ToDoRepository repository) {
        return args -> repository.save(new ToDo("feed dog"));
    }
}
