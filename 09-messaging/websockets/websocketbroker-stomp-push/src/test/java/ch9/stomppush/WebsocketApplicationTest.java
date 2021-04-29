package ch9.stomppush;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class WebsocketApplicationTest {

    @Autowired
    private AbstractSubscribableChannel clientInboundChannel;

    @Autowired
    private AbstractSubscribableChannel clientOutboundChannel;

    @Autowired
    private AbstractSubscribableChannel brokerChannel;

    @Test
    public void test() {
        final TestChannelInterceptor clientOutboundChannelInterceptor = new TestChannelInterceptor();
        clientOutboundChannelInterceptor.setIncludedDestinations("greetings/app/greeting");

        clientOutboundChannel.addInterceptor(clientOutboundChannelInterceptor);

        clientOutboundChannel.subscribe(message -> System.out.println("message " + message.toString()));

        clientInboundChannel.subscribe(message -> System.out.println("message " + message.toString()));

        try {
            clientOutboundChannelInterceptor.awaitMessage(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(clientOutboundChannel.getSubscribers());


    }

    class TestChannelInterceptor implements ChannelInterceptor {
        private final BlockingQueue<Message<?>> messages = new ArrayBlockingQueue<>(100);

        private final List<String> destinationPatterns = new ArrayList<>();

        private final PathMatcher matcher = new AntPathMatcher();


        public void setIncludedDestinations(String... patterns) {
            this.destinationPatterns.addAll(Arrays.asList(patterns));
        }

        /**
         * @return the next received message or {@code null} if the specified time elapses
         */
        public Message<?> awaitMessage(long timeoutInSeconds) throws InterruptedException {
            return this.messages.poll(timeoutInSeconds, TimeUnit.SECONDS);
        }

        @Override
        public Message<?> preSend(Message<?> message, MessageChannel channel) {
            if (this.destinationPatterns.isEmpty()) {
                this.messages.add(message);
            } else {
                StompHeaderAccessor headers = StompHeaderAccessor.wrap(message);
                if (headers.getDestination() != null) {
                    for (String pattern : this.destinationPatterns) {
                        if (this.matcher.match(pattern, headers.getDestination())) {
                            this.messages.add(message);
                            break;
                        }
                    }
                }
            }
            return message;
        }
    }

}
