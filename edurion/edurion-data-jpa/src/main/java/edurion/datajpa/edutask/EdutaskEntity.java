package edurion.datajpa.edutask;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.time.LocalDateTime;

// TODO: @MappedSuperClass
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class EdutaskEntity {

    @Id
    private String id; // todo: dont bind too much meaning to field name 'key'

    private String title;
    private Boolean completed;

    @Column(updatable = false)
    @CreatedDate
    private LocalDateTime created; // TODO: to superclass

    @LastModifiedDate
    private LocalDateTime modified; // TODO: to superclass
}
