package springcache.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ServiceClient {
    private final RestTemplate restTemplate;

    @Cacheable("files")
    public String getString(final String id) {
        return restTemplate.getForObject("http://localhost:13999/service/file/" + id, String.class);
    }
}
