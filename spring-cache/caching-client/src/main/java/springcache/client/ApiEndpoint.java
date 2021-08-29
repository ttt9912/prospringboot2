package springcache.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ApiEndpoint {
    private final ServiceClient client;
    private final CacheManager cacheManager;

    @GetMapping("/file/{id}")
    public String getFile(@PathVariable final String id) {
        return client.getString(id);
    }

    @GetMapping("/cache")
    public Collection<String> getChaches() {
        return cacheManager.getCacheNames();
    }

    @GetMapping("/cache/{name}")
    public Object getChache(@PathVariable final String name) {
        return cacheManager.getCache(name).getNativeCache();
    }
}
