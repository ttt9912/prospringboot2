package ch9.redis.producer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoProducer {
    private final RedisTemplate redisTemplate;

    public TodoProducer(final RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void sendTo(String topic, Todo todo) {
        redisTemplate.convertAndSend(topic, todo);
        log.info("TodoProducer > message sent {}", todo);
    }
}
