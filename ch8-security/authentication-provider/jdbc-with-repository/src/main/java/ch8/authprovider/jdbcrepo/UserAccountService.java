package ch8.authprovider.jdbcrepo;

import ch8.authprovider.jdbcrepo.data.UserAccount;
import ch8.authprovider.jdbcrepo.data.UserAccountRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAccountService implements UserDetailsService {
    private final UserAccountRepository repository;

    public UserAccountService(final UserAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private UserDetails createUserDetails(final UserAccount userAccount) {
        return User.builder()
                .username(userAccount.getUsername())
                .password(userAccount.getPassword())
                .authorities(this.createAuthorities(userAccount.getAuthorities()))
                .build();
    }

    private List<GrantedAuthority> createAuthorities(final List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
