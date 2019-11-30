package keycloaksso.springsecurity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Slf4j
@RestController
@RequestMapping("api/principal")
public class PrincipalInfoController {

    @GetMapping
    public String getPrincipal(Principal principal) {
        log.info(">> logged in as {}", principal.toString());
        return principal.toString();
    }
}
