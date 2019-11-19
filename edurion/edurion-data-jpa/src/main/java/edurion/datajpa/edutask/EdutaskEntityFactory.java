package edurion.datajpa.edutask;

import edurion.business.edutask.Edutask;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class EdutaskEntityFactory {

    static EdutaskEntity createEdutaskEntity(final Edutask edutask) {
        if (edutask == null) {
            return null;
        }

        return new EdutaskEntity(
                edutask.getKey(),
                edutask.getTitle(),
                edutask.getCompleted(),
                edutask.getCreated(),
                edutask.getModified());
    }
}
