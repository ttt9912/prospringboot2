package keycloacksso.plain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/principal")
public class PrincipalInfoController {

    @GetMapping
    public String getPrincipal(Principal principal) {
        return principal.toString();
    }
}
