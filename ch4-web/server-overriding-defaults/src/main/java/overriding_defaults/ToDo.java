package overriding_defaults;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/*
 * # DateFormat
 * - Date          - defined in application.yml
 * - LocalDateTime - defined using @JsonFormat
 */
@Data
public class ToDo {
    private String description;

    private Date created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modified;

    public ToDo(final String description) {
        this.description = description;
        this.created = Date.from(Instant.now());
        this.modified = LocalDateTime.now();
    }
}
