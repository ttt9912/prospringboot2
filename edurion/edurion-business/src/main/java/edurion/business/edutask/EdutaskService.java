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

    public void create(Edutask eduTask) {
        eduTaskRepository.save(eduTask);
    }

    public void complete(Edutask eduTask) {
        eduTask.setCompleted(true);
        eduTaskRepository.update(eduTask);
    }
}
