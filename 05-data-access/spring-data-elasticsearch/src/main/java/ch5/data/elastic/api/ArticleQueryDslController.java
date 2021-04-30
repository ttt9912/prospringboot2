package ch5.data.elastic.api;

import ch5.data.elastic.data.Article;
import ch5.data.elastic.repository.ArticleQueryDslService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dsl")
@RequiredArgsConstructor
public class ArticleQueryDslController {
    private final ArticleQueryDslService queryDslService;

    /*
     * Regex is hardcoded for simplicity
     */
    @GetMapping("/regex")
    public SearchHits<Article> findWithTitleRegex() {
        return queryDslService.findWithRegex();
    }

    /*
     * Search string is hardcoded for simplicity
     */
    @GetMapping("/similar")
    public SearchHits<Article> findWithTitleMatching75Percent() {
        return queryDslService.findWith75PercentSimilarTitle();
    }
}
