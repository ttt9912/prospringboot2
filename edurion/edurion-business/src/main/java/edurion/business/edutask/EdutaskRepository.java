package edurion.business.edutask;

import java.util.List;

public interface EdutaskRepository { // todo: abstract (generic key, value)
    Edutask findByKey(String key);

    List<Edutask> findAll();

    void save(Edutask eduTask);

    void update(Edutask eduTask);

    void delete(String key);
}
