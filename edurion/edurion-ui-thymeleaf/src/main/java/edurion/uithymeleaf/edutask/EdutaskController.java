package edurion.uithymeleaf.edutask;

import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*
 * @RestController - 'return String' -> returns plain text
 *
 * @Controller - 'return String' -> returns view name
 */
// TODO: use DTO
@Controller
public class EdutaskController {
    private final EdutaskService edutaskService;

    public EdutaskController(final EdutaskService edutaskService) {
        this.edutaskService = edutaskService;
    }

    @GetMapping("/edutasks")
    public String listAll(Model model) {
        final List<Edutask> edutasks = edutaskService.findAll();
        model.addAttribute("edutasks", edutasks);
        return "edutask-list";
    }
}
