package edurion.datajpa.edutask;

import edurion.business.edutask.Edutask;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
final class EdutaskEntityFactory {

    static EdutaskEntity createEdutaskEntity(final Edutask edutask) {
        if (edutask == null) {
            return null;
        }

        return new EdutaskEntity(
                edutask.getKey(),
                edutask.getTitle(),
                edutask.getCreated(),
                edutask.getModified(),
                edutask.getCompleted());
    }
}
