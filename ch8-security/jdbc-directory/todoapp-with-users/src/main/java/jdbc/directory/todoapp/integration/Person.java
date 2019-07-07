package jdbc.directory.todoapp.integration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/*
 * Reduced Person (person-directory) instance
 * Person objects from person-directory will be serialized into this Person class here
 *
 * @JsonIgnoreProperties(ignoreUnknown = true)
 *  - ignore additional properties on person-directory Person instances
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person {
    private String email;
    private String password;
    private String role;
    private boolean enabled;
}
