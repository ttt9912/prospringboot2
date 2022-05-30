package ch5.data.jpa.envers.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.history.RevisionRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String>,
        RevisionRepository<Person, String, Long> {

    @Override
    List<Person> findAll();
}
