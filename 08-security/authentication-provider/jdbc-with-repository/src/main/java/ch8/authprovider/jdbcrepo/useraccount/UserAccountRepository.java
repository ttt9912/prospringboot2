package ch8.authprovider.jdbcrepo.useraccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, String> {
    Optional<UserAccount> findByUsername(String username);
}
