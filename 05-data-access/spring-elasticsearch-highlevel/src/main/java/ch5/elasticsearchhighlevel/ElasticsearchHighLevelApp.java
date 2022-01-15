package ch5.elasticsearchhighlevel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchRestClientAutoConfiguration;

@SpringBootApplication(exclude = ElasticsearchRestClientAutoConfiguration.class)
public class ElasticsearchHighLevelApp {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchHighLevelApp.class, args);
    }
}
