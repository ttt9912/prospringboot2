package ch4.server.https.ssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * -----------------------------------------------------------------------------
 * 1. Getting an SSL certificate (Keytool)
 * -----------------------------------------------------------------------------
 * - generate self-signed certificate (dev, test purposes)
 *   create Keystore (.jks or .p12 file) containing a new SSL certificate
 *   > keytool -genkeypair -alias tomcat -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650
 *
 * - use a certificate issued by a trusted Certificate Authority (prod purpose)
 *
 * # Keytool (JDK)
 * certificate management utility - generate a pair of cryptographic keys,
 * use them to produce an SSL certificate and store it in a keystore
 *
 * -----------------------------------------------------------------------------
 * 2. Configuring SSL in Spring Boot
 * -----------------------------------------------------------------------------
 * - Spring boot ssl properties
 *
 * -----------------------------------------------------------------------------
 * 3. Redirect HTTP requests to HTTPS (optional)
 * -----------------------------------------------------------------------------
 * without redirect, HTTP calls would return an error in the browser
 * Spring allows defining just one network connector in application.yaml file.
 * Since we have used it for HTTPS, we have to set the HTTP connector
 * programmatically
 * - https://www.thomasvitale.com/https-spring-boot-ssl-certificate/ *
 * -----------------------------------------------------------------------------
 * 4. Distribute the SSL certificate to clients (optional)
 * -----------------------------------------------------------------------------
 * so that the browser will not cry about insecure localhost connections...
 * - https://www.thomasvitale.com/https-spring-boot-ssl-certificate/
 */
@SpringBootApplication
public class HttpsServer {
    public static void main(String[] args) {
        SpringApplication.run(HttpsServer.class, args);
    }
}
