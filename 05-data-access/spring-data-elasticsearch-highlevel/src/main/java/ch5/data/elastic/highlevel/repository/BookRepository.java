package ch5.data.elastic.highlevel.repository;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final ElasticsearchRestTemplate elasticsearchRestTemplate;
    private final RestHighLevelClient highLevelClient;

    public List findAll(){
        return List.of();
    }
}
