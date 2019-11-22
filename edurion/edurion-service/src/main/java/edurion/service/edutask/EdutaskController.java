package edurion.service.edutask;

import edurion.business.edutask.Edutask;
import edurion.business.edutask.EdutaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("edutask")
public class EdutaskController {
    private final EdutaskService edutaskService;

    public EdutaskController(final EdutaskService edutaskService) {
        this.edutaskService = edutaskService;
    }

    @GetMapping
    public List<Edutask> findAll() {
        return edutaskService.findAll();
    }

    @GetMapping("/{key}")
    public Edutask findByKey(@PathVariable("key") final String key) {
        return edutaskService.findByKey(key);
    }

}
