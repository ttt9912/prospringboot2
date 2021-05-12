package ch5.data.elastic.api;

import ch5.data.elastic.data.Article;
import ch5.data.elastic.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleRepository repository;

    /*
     * returns a Page<T> implementation ==> AggregatedPageImpl
     */
    @GetMapping
    public Iterable<Article> getArticles() {
        return repository.findAll();
    }

    /*
     * Page<T> - object provides the total number of hits for the query along with other pagination information
     *
     * Page<T>
     *      extends Slice<T>
     *          extends Streamable<T>
     *              extends Iterable<T>, Supplier<Stream<T>>
     */
    @GetMapping("/{author}")
    public Page<Article> getArticlesByAuthor(@PathVariable("author") final String author) {
        return repository.findByAuthorsName(author, Pageable.unpaged()); // alternative: PageRequest.of(0, 10);
    }
}
