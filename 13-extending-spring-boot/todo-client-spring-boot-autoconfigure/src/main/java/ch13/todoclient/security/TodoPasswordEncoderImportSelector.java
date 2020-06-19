package ch13.todoclient.security;

import ch13.todoclient.annotation.Algorithm;
import ch13.todoclient.annotation.EnableTodoPasswordEncoder;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/*
 * triggers a configuration if the @EnableToDoSecurity is declared
 *
 * ImportSelector
 * - Spring Boot tracks every class that implements the ImportSelector interface
 * - imports
 *
 */
public class TodoPasswordEncoderImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(final AnnotationMetadata annotationMetadata) {
        final AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                annotationMetadata.getAnnotationAttributes(EnableTodoPasswordEncoder.class.getName(), false));

        final Algorithm algorithm = annotationAttributes.getEnum("algorithm");

        switch (algorithm) {
            case PBKDF2:
                return new String[]{"ch13.todoclient.security.Pbkdf2Encoder"};
            case BCRYPT:
            default:
                return new String[]{"ch13.todoclient.security.BCryptPasswordEncoderConfig"};
        }
    }
}
