package ch9.redis.consumer;

import common.todo.data.jpa.todo.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Configuration
public class TodoConsumerConfig {

    /*
     * RedisMessageListenerContainer - connecting to a Redis topic
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory connectionFactory,
            MessageListenerAdapter listenerAdapter,
            @Value("${todo.redis.topic}") String topic) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(topic));
        return container;
    }

    /*
     * MessageListenerAdapter
     * - takes a pojo with a handleMessage method (TodoConsumer)
     * - requires a serializer because it receives the message as instance
     */
    @Bean
    public MessageListenerAdapter messageListenerAdapter(TodoConsumer consumer, Jackson2JsonRedisSerializer todoSerializer) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
        messageListenerAdapter.setSerializer(todoSerializer);
        return messageListenerAdapter;
    }
}
