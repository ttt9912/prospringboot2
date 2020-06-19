package ch6.webflux.webflux.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ToDo {

    private Integer id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;

    public ToDo(final Integer id, final String description, final Boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }
}
