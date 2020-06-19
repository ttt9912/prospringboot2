package ch11.cloudstream.source.data;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Todo {
    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean completed;

    public Todo() {
        this.id = UUID.randomUUID().toString();
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public Todo(String description) {
        this();
        this.description = description;
    }

    public Todo(String description, boolean completed) {
        this(description);
        this.completed = completed;
    }
}
