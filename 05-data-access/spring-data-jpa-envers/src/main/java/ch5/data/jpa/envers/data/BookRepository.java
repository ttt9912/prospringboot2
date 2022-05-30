package ch5.data.jpa.envers.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, String> {

    @Override
    List<Book> findAll();
}
