package edurion.service.edutask;

import edurion.business.edutask.Edutask;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class EdutaskDtoFactory {

    static EdutaskDto createEdutaskDto(final Edutask edutask) {
        if (edutask == null) {
            return null;
        }
        return new EdutaskDto(edutask.getKey(), edutask.getTitle(), edutask.getCompleted());
    }

    static List<EdutaskDto> createEdutaskDtos(final List<Edutask> edutasks) {
        if (edutasks == null) {
            return Collections.emptyList();
        }
        return edutasks.stream()
                .map(EdutaskDtoFactory::createEdutaskDto)
                .collect(Collectors.toList());
    }
}
