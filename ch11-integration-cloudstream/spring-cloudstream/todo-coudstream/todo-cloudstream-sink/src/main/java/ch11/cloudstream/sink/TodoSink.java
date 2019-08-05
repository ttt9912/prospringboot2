package ch11.cloudstream.sink;

import ch11.cloudstream.sink.data.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class TodoSink {

    @StreamListener(Sink.INPUT)
    public void process(Todo message) {
        log.info("SINK >> Message Received {}", message);
    }
}
