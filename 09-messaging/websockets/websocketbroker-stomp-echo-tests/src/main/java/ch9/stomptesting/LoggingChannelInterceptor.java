package ch9.stomptesting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

import java.util.stream.Collectors;

@Slf4j
public class LoggingChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(final Message<?> message, final MessageChannel channel) {
        logMessage(message, channel);
        return message;
    }


    private void logMessage(final Message<?> message, final MessageChannel channel) {
        log.info("\n> {} {} \n\n\tpayload: {}", channel,
                formatHeaders(message),
                message.getPayload());
    }

    private String formatHeaders(final Message<?> message) {
        return message.getHeaders().entrySet().stream()
                .map(e -> "\n\t" + e.getKey() + ": " + e.getValue())
                .collect(Collectors.joining(""));
    }
}
