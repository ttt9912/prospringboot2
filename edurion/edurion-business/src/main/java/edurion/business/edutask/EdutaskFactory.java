package edurion.business.edutask;

import java.time.LocalDateTime;
import java.util.UUID;

// TODO: abstract factory?
public class EdutaskFactory {

    public static Edutask createEdutask(String title) {
        return new Edutask(UUID.randomUUID().toString(), title,
                LocalDateTime.now(), LocalDateTime.now(), false);
    }
}
