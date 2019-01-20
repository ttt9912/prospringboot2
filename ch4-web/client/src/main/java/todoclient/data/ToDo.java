package todoclient.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/*
 * javax.validation @NotNull, @NotBlank
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {
    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;

    public ToDo(final String description) {
        this.description = description;
        this.id = UUID.randomUUID().toString();
        final LocalDateTime now = LocalDateTime.now();
        this.created = now;
        this.modified = now;
        this.completed = false;
    }
}
