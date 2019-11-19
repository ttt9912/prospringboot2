package edurion.datajpa.edutask;

import edurion.datajpa.EdurionDataJpaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EdurionDataJpaConfig.class)
public class EdutaskCrudRepositoryTest {

    @Autowired
    private EdutaskCrudRepository repository;

    @Test
    public void testAuditing() {
        EdutaskEntity edutaskEntity = createEdutaskEntity();
        repository.save(edutaskEntity);

        EdutaskEntity saved = repository.findById(edutaskEntity.getId()).orElse(null);
        assertThat(saved).isNotNull();
        assertThat(saved.getCreated()).isNotNull();
        assertThat(saved.getModified()).isNotNull();
    }

    private EdutaskEntity createEdutaskEntity() {
        return new EdutaskEntity(UUID.randomUUID().toString(), "feed dog", false, null, null);
    }
}