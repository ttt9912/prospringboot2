package ch8.authprovider.jdbcdirectory.todoapp.security;

import ch8.authprovider.jdbcdirectory.todoapp.client.Person;
import ch8.authprovider.jdbcdirectory.todoapp.client.PersonDirectoryClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PersonUserDetailsService implements UserDetailsService {
    private final PersonDirectoryClient personDirectoryClient;

    public PersonUserDetailsService(final PersonDirectoryClient personDirectoryClient) {
        this.personDirectoryClient = personDirectoryClient;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Person person = personDirectoryClient.loadPersonByEmail(username);

        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        return User.withUsername(person.getEmail())
                .password(encoder.encode(person.getPassword()))
                .accountLocked(!person.isEnabled())
                .roles(person.getRole())
                .build();
    }
}
