package edurion.datajpa.edutask;

import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskRepository;
import edurion.datajpa.util.RepositoryUtil;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EdutaskRepositoryImpl implements EdutaskRepository {
    private final EdutaskCrudRepository crudRepository;

    public EdutaskRepositoryImpl(final EdutaskCrudRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    @Override
    public Edutask findByKey(final String key) {
        return crudRepository.findById(key)
                .map(EdutaskFactory::createEdutask)
                .orElse(null);
    }

    @Override
    public List<Edutask> findAll() {
        return RepositoryUtil.toStream(crudRepository.findAll())
                .map(EdutaskFactory::createEdutask)
                .collect(Collectors.toList());
    }

    @Override
    public void save(final Edutask edutask) {
        crudRepository.save(EdutaskEntityFactory.createEdutaskEntity(edutask));
    }

    @Override
    public void update(final Edutask edutask) {
        final Edutask existing = findByKey(edutask.getKey());

        if (existing == null) {
            throw new RuntimeException("Edutask with key=" + edutask.getKey() + " does not exist");
        }

        crudRepository.save(EdutaskEntityFactory.createEdutaskEntity(edutask));
    }

    @Override
    public void delete(final String key) {
        crudRepository.deleteById(key);
    }
}
