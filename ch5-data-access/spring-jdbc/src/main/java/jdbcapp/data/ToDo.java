package jdbcapp.data;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ToDo {
    @NotNull
    private String id;
    @NotNull
    @NotBlank
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
