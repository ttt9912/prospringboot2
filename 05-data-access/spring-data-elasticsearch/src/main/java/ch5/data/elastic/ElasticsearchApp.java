package ch5.data.elastic;

import ch5.data.elastic.data.Article;
import ch5.data.elastic.data.Author;
import ch5.data.elastic.repository.ArticleRepository;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.List;

/*
 * RestHighLevelClient - connect to the Elasticsearch instance
 *
 * Queries
 *  - Spring repository
 *  - @Query (on Spring repository methods)
 *  - High Level REST Client - contains a lot of APIs
 *      https://www.elastic.co/guide/en/elasticsearch/client/java-rest/current/java-rest-high.html
 *  - Query dsl (using ElasticsearchRestTemplate - deprecated)
 *      https://www.baeldung.com/spring-data-elasticsearch-queries
 *      https://www.elastic.co/guide/en/elasticsearch/reference/current/query-dsl.html
 */
@SpringBootApplication
public class ElasticsearchApp {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApp.class, args);
    }

    @Bean
    CommandLineRunner init(ArticleRepository repository) {
        return args -> {
            final Author johnSmith = new Author("John Smith");
            final Author johnDoe = new Author("John Doe");

            final Article article1 = new Article();
            article1.setTitle("Spring Data Elasticsearch");
            article1.setAuthors(List.of(johnSmith, johnDoe));
            article1.setTags(new String[]{"elasticsearch", "spring data"});
            repository.save(article1);

            final Article article2 = new Article();
            article2.setTitle("Search engines");
            article2.setAuthors(List.of(johnDoe));
            article2.setTags(new String[]{"search engines", "tutorial"});
            repository.save(article2);

            final Article article3 = new Article();
            article3.setTitle("Second Article About Elasticsearch");
            article3.setAuthors(List.of(johnSmith));
            article3.setTags(new String[]{"elasticsearch", "spring data"});
            repository.save(article3);

            final Article article4 = new Article();
            article4.setTitle("Elasticsearch Tutorial");
            article4.setAuthors(List.of(johnDoe));
            article4.setTags(new String[]{"elasticsearch"});
            repository.save(article4);
        };
    }

}
