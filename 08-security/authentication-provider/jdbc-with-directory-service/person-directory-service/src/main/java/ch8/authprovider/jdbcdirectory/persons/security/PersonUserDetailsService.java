package ch8.authprovider.jdbcdirectory.persons.security;

import ch8.authprovider.jdbcdirectory.persons.data.Person;
import ch8.authprovider.jdbcdirectory.persons.data.PersonRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PersonUserDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public PersonUserDetailsService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final Person person = personRepository.findByEmailIgnoreCase(username);

        if (person == null) {
            throw new UsernameNotFoundException(username);
        }

        return User
                .withUsername(person.getEmail())
                .accountLocked(!person.isEnabled())
                .password(encoder.encode(person.getPassword()))
                .roles(person.getRole())
                .build();
    }
}
