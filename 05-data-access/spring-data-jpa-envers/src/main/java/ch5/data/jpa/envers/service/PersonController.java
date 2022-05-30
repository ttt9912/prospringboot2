package ch5.data.jpa.envers.service;

import ch5.data.jpa.envers.data.Person;
import ch5.data.jpa.envers.data.PersonRepository;
import org.springframework.data.history.Revision;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    private final PersonRepository repository;

    public PersonController(final PersonRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Person> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{ahvId}")
    public Optional<Person> findById(@PathVariable("ahvId") String ahvId) {
        return repository.findById(ahvId);
    }

    @GetMapping("/{ahvId}/versions")
    public List<Person> findByIdAllVersions(@PathVariable("ahvId") String ahvId) {
        return repository.findRevisions(ahvId).getContent().stream()
                .map(Revision::getEntity)
                .collect(Collectors.toList());
    }
}
