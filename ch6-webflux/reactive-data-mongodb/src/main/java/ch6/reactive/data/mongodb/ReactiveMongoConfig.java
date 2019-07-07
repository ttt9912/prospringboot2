package ch6.reactive.data.mongodb;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/*
 * Setup connection to embedded MongoDB server
 *
 * @EnableReactiveMongoRepositories - provide location of the repositories
 * if not in the same package
 *
 * AbstractReactiveMongoConfiguration - setup embedded mongo Mongo
 */
@Configuration
@EnableReactiveMongoRepositories(basePackages = "reactivedata.data")
public class ReactiveMongoConfig extends AbstractReactiveMongoConfiguration {
    private final Environment environment;

    public ReactiveMongoConfig(final Environment environment) {
        this.environment = environment;
    }

    @Override
    protected String getDatabaseName() {
        return "todos";
    }

    @Override
    @Bean
    @DependsOn("embeddedMongoServer")
    public MongoClient reactiveMongoClient() {
        Integer port = environment.getProperty("local.mongo.port", Integer.class);
        return MongoClients.create(String.format("mongodb://localhost:%d", port));
    }
}
