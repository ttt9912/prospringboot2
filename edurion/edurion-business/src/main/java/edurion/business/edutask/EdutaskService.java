package edurion.business.edutask;

import java.util.List;

public class EdutaskService {
    private final EdutaskRepository eduTaskRepository;

    public EdutaskService(final EdutaskRepository eduTaskRepository) {
        this.eduTaskRepository = eduTaskRepository;
    }

    public List<Edutask> findAll() {
        return eduTaskRepository.findAll();
    }

    public Edutask findByKey(String key) {
        return eduTaskRepository.findByKey(key);
    }

    public void create(String title, Boolean completed) {
        eduTaskRepository.save(EdutaskFactory.createEdutask(title, completed));
    }

    public void update(String key, String title, Boolean completed) {
        eduTaskRepository.update(EdutaskFactory.createEdutask(key, title, completed));
    }

    public void delete(final String key) {
        eduTaskRepository.delete(key);
    }
}
