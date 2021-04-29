package ch8.passwordencoders;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

/*
 * ---------------------------------------------------------------------------------
 * PasswordEncoder
 * ---------------------------------------------------------------------------------
 * Perform a one way transformation of a password to allow the password to be stored
 * securely
 *
 * Typically PasswordEncoder is used for storing a password that needs to be compared
 * to a user provided password at the time of authentication.
 */
public class PasswordEncodersDemo {

    /*
     * -------------------------------------------------
     * DelegatingPasswordEncoder
     * -------------------------------------------------
     * - contains most common password encoders
     * - passwords are saved in the format
     *          {encoderId}encodedPassword
     */
    @Test
    public void delegatingPasswordEncoder() {
        final PasswordEncoder delegatingPasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String password1 = "{bcrypt}$2a$10$ZD/PoFTlADlTXRs7yOjpZO2hvsCdrc8ykxx0KcSSYo1OI7rGlfj4e";  // decrypted with BCryptPasswordEncoder
        String password2 = "{noop}secret123"; // decrypted with NoOpPasswordEncoder

        // encode (uses bcrypt by default)
        System.out.println(delegatingPasswordEncoder.encode("secret123"));

        // decode
        assertThat(delegatingPasswordEncoder.matches("secret123", password1));
        assertThat(delegatingPasswordEncoder.matches("secret123", password2));
    }

    /*
     * -------------------------------------------------
     * specific PasswordEncoder
     * -------------------------------------------------
     * - {id} prefix is not necessary
     */
    @Test
    public void specificPasswordEncoder() {
        final Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();

        String password = "717ca6eb73d38ffaa7228a1fb2967ffb8fe4e2a44f94ab576391ec72c8b3b530af19f46c6fc7a869";

        // encode
        System.out.println(pbkdf2PasswordEncoder.encode("secret123"));

        // decode
        assertThat(pbkdf2PasswordEncoder.matches("secret123", password));
    }
}
