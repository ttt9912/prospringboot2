package edurion.service.edutask;

import edurion.business.edutask.EdutaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/edutasks")
public class EdutaskController {
    private final EdutaskService edutaskService;

    public EdutaskController(final EdutaskService edutaskService) {
        this.edutaskService = edutaskService;
    }

    @GetMapping
    public List<EdutaskDto> findAll() {
        return EdutaskDtoFactory.createEdutaskDtos(edutaskService.findAll());
    }

    @GetMapping("/{key}")
    public EdutaskDto findByKey(@PathVariable("key") final String key) {
        return EdutaskDtoFactory.createEdutaskDto(edutaskService.findByKey(key));
    }

}
