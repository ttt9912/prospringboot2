package edurion.business.edutask;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.UUID;

// TODO: abstract factory?
@NoArgsConstructor(access = AccessLevel.PRIVATE)
final class EdutaskFactory {

    public static Edutask createEdutask(String title) {
        return createEdutask(title, false);
    }

    static Edutask createEdutask(String title, Boolean completed) {
        return new Edutask(generateKey(), title, completed, null, null);
    }

    static Edutask createEdutask(String key, String title, Boolean completed) {
        return new Edutask(key, title, completed, null, null);
    }

    private static String generateKey() {
        return UUID.randomUUID().toString();
    }
}
