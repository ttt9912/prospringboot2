package caching.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("service")
public class ServiceController {

    @GetMapping("/file/{id}")
    public String getFile(@PathVariable final String id) {
        log.info(">>> Requesting File {}", id);
        return "Hello World " + id;
    }
}
