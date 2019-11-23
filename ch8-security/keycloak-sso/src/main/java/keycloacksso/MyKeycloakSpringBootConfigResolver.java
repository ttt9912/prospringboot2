package keycloacksso;

import org.springframework.context.annotation.Configuration;

/*
 * TEMPORARY WORKAROUND
 * https://stackoverflow.com/questions/57787768/issues-running-example-keycloak-spring-boot-app
 * https://medium.com/keycloak/secure-spring-boot-2-using-keycloak-f755bc255b68
 */
@Configuration
// public class MyKeycloakSpringBootConfigResolver extends KeycloakWebSecurityConfigurerAdapter {
public class MyKeycloakSpringBootConfigResolver {

    /*
    @Bean
    public KeycloakSpringBootConfigResolver KeycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
    */

    /*
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }*/
}
