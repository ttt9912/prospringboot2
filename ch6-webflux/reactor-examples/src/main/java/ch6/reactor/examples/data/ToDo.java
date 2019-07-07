package ch6.reactor.examples.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ToDo {

    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;

    public ToDo(final String description, final Boolean completed) {
        this.description = description;
        this.completed = completed;
    }
}
