package edurion.uithymeleaf.edutask;

import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @RestController - 'return String' -> returns plain text
 *
 * @Controller - 'return String' -> returns view name
 */
@Controller
public class EdutaskController {
    private final EdutaskService edutaskService;

    public EdutaskController(final EdutaskService edutaskService) {
        this.edutaskService = edutaskService;
    }

    @GetMapping("/list")
    public String listAll(Model model) {
        final List<Edutask> edutasks = edutaskService.findAll();
        model.addAttribute("edutasks", EdutaskDtoFactory.createEdutaskDtos(edutasks));
        return "edutask-list";
    }

    // Parameter EdutaskDto is bound to the edutask-add.html page
    @GetMapping("/add")
    public String add(EdutaskDto edutaskDto) {
        return "edutask-add";
    }

    @PostMapping("/save")
    public String save(@Valid EdutaskDto edutaskDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edutask-add";
        }
        edutaskService.create(edutaskDto.getTitle(), edutaskDto.getCompleted());
        final List<Edutask> edutasks = edutaskService.findAll();
        model.addAttribute("edutasks", EdutaskDtoFactory.createEdutaskDtos(edutasks));
        return "edutask-list";
    }


}
