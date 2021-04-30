package ch5.data.elastic.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.InnerField;
import org.springframework.data.elasticsearch.annotations.MultiField;

import java.util.List;

import static org.springframework.data.elasticsearch.annotations.FieldType.*;

/*
 * - Nested
 * allows to define the Author class separately, but have the individual
 * instances of author embedded in an Article document when it is indexed
 * in Elasticsearch
 */
@Data
@Document(indexName = "articles") // TODO: type="article" property
public class Article {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = Text, fielddata = true), otherFields = {@InnerField(suffix = "verbatim", type = Keyword)})
    private String title;

    @Field(type = Nested, includeInParent = true)
    private List<Author> authors;

    @Field(type = Keyword)
    private String[] tags;
}
