package ch5.data.jpa.envers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.Version;

import javax.persistence.Entity;
import javax.persistence.Id;

@Audited
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private String ahvNr;
    private String firstname;
    private String lastname;
   // @Version
   // Long version;
}
