package nosql.mongodb;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/*
 * Configure MongoClient for MongoDB Embedded Server
 *
 * MongoDB Embedded uses a random port!
 */
@Configuration
public class MongoClientConfig {
    private final Environment environment;

    public MongoClientConfig(final Environment environment) {
        this.environment = environment;
    }

    @Bean
    public MongoClient mongoClient() {
        Integer port = environment.getProperty("local.mongo.port", Integer.class);
        return new MongoClient("localhost", port);
    }
}
