package ch9.redis.producer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Configuration
public class TodoProducerConfig {

    /*
     * - requires a serializer
     * - alternative: use StringRedisTemplate
     */
    @Bean
    public RedisTemplate<String, Todo> redisTemplate(RedisConnectionFactory connectionFactory, Jackson2JsonRedisSerializer todoSerializer) {
        RedisTemplate<String, Todo> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(todoSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
