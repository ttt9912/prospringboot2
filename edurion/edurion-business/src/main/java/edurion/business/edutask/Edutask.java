package edurion.business.edutask;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Edutask {
    private String key; // todo: dont bind too much meaning to field name 'key'
    private String title;
    private LocalDateTime created; // TODO: to superclass
    private LocalDateTime modified; // TODO: to superclass
    private Boolean completed;
}