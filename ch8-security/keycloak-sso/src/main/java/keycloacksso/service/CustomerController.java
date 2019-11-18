package keycloacksso.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * @RestController - delivers plain string
 *
 * @Controller - delivers ui with the corresponding name
 */
@Controller
public class CustomerController {

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Model model) {
        // addCustomers();
        //model.addAttribute("customers", customerDAO.findAll());
        return "customers";
    }
}
