package ch5.data.elastic.repository;

import ch5.data.elastic.data.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.regexpQuery;

@Service
@RequiredArgsConstructor
public class ArticleQueryDslService {
    private final ElasticsearchRestTemplate elasticsearchTemplate;

    public SearchHits<Article> findWithRegex() {
        Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(regexpQuery("title", ".*data.*"))
                .build();
        return elasticsearchTemplate.search(searchQuery, Article.class, IndexCoordinates.of("articles"));
    }

    public SearchHits<Article> findWith75PercentSimilarTitle() {
        Query searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("title", "Spring Data Elasticsearch").minimumShouldMatch("75%"))
                .build();
        return elasticsearchTemplate.search(searchQuery, Article.class, IndexCoordinates.of("articles"));
    }
}
