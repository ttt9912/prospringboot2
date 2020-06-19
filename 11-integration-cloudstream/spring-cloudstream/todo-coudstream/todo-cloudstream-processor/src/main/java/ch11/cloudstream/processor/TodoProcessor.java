package ch11.cloudstream.processor;

import ch11.cloudstream.processor.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

import java.time.LocalDateTime;

/*
 * @EnableBinding
 * - enables this class as a Spring Cloud Stream application
 * - enables the necessary configuration for sending or receiving messages
 *   through the binder provided
 *
 * Processor
 * - marks the Spring Cloud Stream app as a Processor stream
 * - creates the necessary channels (input & output beans)
 */
@Slf4j
@EnableBinding(Processor.class)
public class TodoProcessor {

    /*
     * @StreamListener
     * - very similar to @RabbitListener or @JmsListener
     * - listens for for new incoming messages in the Processor.INPUT channel (SubscribableChannel input())
     *
     * @SendTo
     * -  sends a message to the Processor.OUTPUT channel (MessageChannel output())
     */
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public Todo transform(Todo message) {
        log.info("TodoProcessor >> processing {}", message);
        message.setCompleted(true);
        message.setModified(LocalDateTime.now());
        log.info("TodoProcessor >> processed {}", message);
        return message;
    }
}
