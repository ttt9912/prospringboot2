package ch5.data.jpa.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/*
 * ---------------------------------------------------------------------------------
 * @Id
 * ---------------------------------------------------------------------------------
 * primary key, should be any Java primitive type or wrapper
 *
 * ---------------------------------------------------------------------------------
 * @GeneratedValue
 * ---------------------------------------------------------------------------------
 * provides the generation strategies for the values of primary keys
 *
 * # strategy
 * - AUTO:      (default) provider should pick an appropriate strategy
 * - IDENTIY:   (slow) auto-incremented database column
 *              db generates a new value with each insert
 *              drawback: Hibernate requires a primary key value for each managed
 *              entity and therefore has to perform the insert statement immediately
 * - SEQUENCE:  (preferred) uses a database sequence to generate unique values
 *              requires additional select statements to get the next value from a database sequence
 *              Hibernate will request the next value from its default sequence.
 *              You can change that by referencing the name of a @SequenceGenerator
 * - TABLE:     (slow) simulates a sequence by storing and updating its current value
 *              in a database table which requires the use of pessimistic locks
 *              @TableGenerator (optional) specifies the database table which
 *              Hibernate shall use to simulate the sequence
 *
 * # generator (optional)
 * name of the @GenericGenerator - use a hibernate generator or define a primary key
 * generator using @SequenceGenerator or @TableGenerator
 *
 * ---------------------------------------------------------------------------------
 * @GenericGenerator
 * ---------------------------------------------------------------------------------
 * hibernate annotation used to denote a custom generator, which can be a class or
 * shortcut to a generator supplied by Hibernate
 *
 * # predefined hibernate generators
 * assigned, increment, sequence, hilo, identity, native, foreign, uuid
 *
 * ---------------------------------------------------------------------------------
 * Callbacks
 * ---------------------------------------------------------------------------------
 * @PrePersist, @PreUpdate, @PreRemove
 * @PostPersist, @PostUpdate, @PostRemove
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo {

    @NotNull
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @NotNull
    @NotBlank
    private String description;

    @Column(insertable = true, updatable = false)
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;


    @PrePersist
    void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate
    void onUpdate() {
        this.setModified(LocalDateTime.now());
    }
}
