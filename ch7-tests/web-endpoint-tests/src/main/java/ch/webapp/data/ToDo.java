package ch.webapp.data;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ToDo implements Serializable {
    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;

    private ToDo() {
        this.id = UUID.randomUUID().toString();
        final LocalDateTime now = LocalDateTime.now();
        this.created = now;
        this.modified = now;
        this.completed = false;
    }

    public ToDo(final String description) {
        this();
        this.description = description;
    }
}
