package ch9.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import common.todo.data.jpa.todo.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class Config {

    /*
     * spring Serializer for Redis
     * (Used by producer and Consumer)
     */
    @Bean
    public Jackson2JsonRedisSerializer todoSerializer() {
        Jackson2JsonRedisSerializer<Todo> serializer = new Jackson2JsonRedisSerializer<>(Todo.class);
        serializer.setObjectMapper(objectMapper());
        return serializer;
    }

    /*
     * ObjectMapper with support for LocalDateTime etc.
     */
    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return objectMapper;
    }
}
