package edurion.uithymeleaf.edutask;

import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

/*
 * @RestController - 'return String' -> returns plain text
 * @Controller - 'return String' -> returns view name
 *
 * -------------
 * GET  /list   -->     return edutask-list UI
 *
 * GET  /add    -->     return edutask-add UI
 * POST /save   -->     post a new DTO
 *
 * GET  /edit   -->     return edutask-edit UI
 * POST /update -->     post an updated DTO
 * -------------
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

    // Parameter edutaskDto is bound to the edutask-add.html page
    @GetMapping("/add")
    public String add(EdutaskDto edutaskDto) {
        return "edutask-add";
    }

    // validation errors will be propagated to thymeleaf
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

    @GetMapping("/edit/{key}")
    public String edit(@PathVariable("key") String key, Model model) {
        final Edutask existing = edutaskService.findByKey(key);
        if (existing == null) {
            throw new RuntimeException("Edutask with key=" + key + " does not exist");
        }
        model.addAttribute("existing", existing);
        return "edutask-update";
    }

    @PostMapping("/update/{key}") // @PutMapping("/{key}")
    public String update(@PathVariable("key") String key, @Valid EdutaskDto edutaskDto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            // user.setId(id);
            return "edutask-update";
        }

        edutaskService.update(edutaskDto.getKey(), edutaskDto.getTitle(), edutaskDto.getCompleted());

        final List<Edutask> edutasks = edutaskService.findAll();
        model.addAttribute("edutasks", EdutaskDtoFactory.createEdutaskDtos(edutasks));
        return "edutask-list";
    }

    @GetMapping("/delete/{key}") // @DeleteMapping("/{key}")
    public String deleteUser(@PathVariable("key") String key, Model model) {
        edutaskService.delete(key);

        final List<Edutask> edutasks = edutaskService.findAll();
        model.addAttribute("edutasks", EdutaskDtoFactory.createEdutaskDtos(edutasks));
        return "edutask-list";
    }

}
