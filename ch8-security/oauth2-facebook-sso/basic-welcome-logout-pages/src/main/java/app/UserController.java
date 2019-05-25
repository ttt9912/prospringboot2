package app;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    /*
     * note: it’s not a great idea to return a whole Principal in a /user endpoint
     * like that - it might contain information you would not reveal to a browser client).
     * -> convert the endpoint to hide the information we don’t need the browser to have
     */
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
