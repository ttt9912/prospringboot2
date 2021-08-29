package springcache.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/*
 * CacheManager
 * - class to interact with the cache
 *
 * Cache Providers
 * - Redis
 * - Hazelcast
 * - Couchbase
 * - etc.
 *
 * @EnableCaching
 * - auto-configures a bean of type ConcurrentMapCacheManager
 * - customize the auto-configured CacheManager by providing a @Component that
 *   implements CacheManagerCustomizer<T>
 *
 * @Cacheable("name")
 * - will skip running the method
 *
 * @CachePut
 * - will actually run the method and update the cache
 *
 *
 * --------------------------------------
 * CREATE Cache Entries
 * --------------------------------------
 * localhost:8080/api/file/123
 * localhost:8080/api/file/456
 *
 * --------------------------------------
 * GET Caches
 * --------------------------------------
 * http://localhost:8080/api/cache/files
 *
 * --------------------------------------
 * GET Entries for cache 'files'
 * --------------------------------------
 * http://localhost:8080/api/cache/files
 */
@EnableCaching
@SpringBootApplication
public class SpringCacheClientApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringCacheClientApp.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
