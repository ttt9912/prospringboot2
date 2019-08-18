package ch11.cloudstream.source;

import ch11.cloudstream.source.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

/*
 * @EnableBinding
 * - convert the app to a Spring Cloud Stream
 *
 * Source
 * - ingesting dto from an external system (Queue, REST, File System, DB, etc)
 * - creates the necessary channels (output channel here)
 *
 * Instead of @InboundChannelAdapter, a spring-integration IntegrationFlow
 * could be used aswell to produce dto
 */
@Slf4j
@EnableBinding(Source.class)
public class TodoSource {

    /*
     * @InboundChannelAdapter
     * - polls the simpleTodo() method every 1 Second!
     * - publishes a Message every second
     *
     * Configure Polling
     * - @InboundChannelAdapter's 'poller' argument
     * - poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "2"))
     */
    @Bean
    @InboundChannelAdapter(channel = Source.OUTPUT)
    public MessageSource<Todo> simpleTodo() {
        return () -> {
            Todo message = new Todo("test Spring Cloud Stream");
            log.info("TodoSource >> sending message {}", message);
            return MessageBuilder
                    .withPayload(message)
                    .build();
        };
    }
}
