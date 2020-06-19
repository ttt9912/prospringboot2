package ch5.data.redis.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/*
 * @RedisHash - persistent
 *
 * @Id - part of a composite key
 *
 * when inserting  an entity, there is a hash that contains a key
 * with format class:key
 */
@RedisHash
@Data
public class ToDo {

    @NotNull
    @Id
    private String id;

    @NotNull
    @NotBlank
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;

    public ToDo() {
        LocalDateTime now = LocalDateTime.now();
        this.id = UUID.randomUUID().toString();
        this.setCreated(now);
        this.setModified(now);
        this.setCompleted(false);
    }

    public ToDo(@NotNull @NotBlank final String description) {
        this();
        this.description = description;
    }
}
