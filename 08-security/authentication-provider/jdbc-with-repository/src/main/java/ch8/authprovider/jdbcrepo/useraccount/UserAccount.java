package ch8.authprovider.jdbcrepo.useraccount;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class UserAccount {

    @Id
    private String username;
    private String email;
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorities;

}
