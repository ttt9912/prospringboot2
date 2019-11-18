package edurion.datajpa.edutask;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EdutaskEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id; // todo: dont bind too much meaning to field name 'key'
    private String title;

    @Column(updatable = false)
    private LocalDateTime created; // TODO: to superclass
    private LocalDateTime modified; // TODO: to superclass
    private Boolean completed;
}
