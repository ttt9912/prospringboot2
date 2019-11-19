package edurion.datajpa.edutask;

import edurion.business.edutask.Edutask;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class EdutaskFactory {

    static Edutask createEdutask(final EdutaskEntity edutaskEntity) {
        if (edutaskEntity == null) {
            return null;
        }

        return new Edutask(
                edutaskEntity.getId(),
                edutaskEntity.getTitle(),
                edutaskEntity.getCreated(),
                edutaskEntity.getModified(),
                edutaskEntity.getCompleted());
    }
}
