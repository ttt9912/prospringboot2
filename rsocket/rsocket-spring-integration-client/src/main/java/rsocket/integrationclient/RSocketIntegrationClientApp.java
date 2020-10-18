package rsocket.integrationclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.transformer.FileToStringTransformer;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.integration.rsocket.ClientRSocketConnector;
import org.springframework.integration.rsocket.RSocketInteractionModel;
import org.springframework.integration.rsocket.dsl.RSocketOutboundGatewaySpec;
import org.springframework.integration.rsocket.dsl.RSockets;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.rsocket.RSocketStrategies;

import java.io.File;

/*
 * Integrate with non-reactive code
 *
 * File data => RSocket => Log
 */
@SpringBootApplication
public class RSocketIntegrationClientApp {

    public static void main(String[] args) {
        SpringApplication.run(RSocketIntegrationClientApp.class, args);
    }

    @Bean
    IntegrationFlow rsocketFlow(@Value("${user.home}") final File home, final ClientRSocketConnector connector) {
        final File folder = new File(new File(home, "Desktop"), "in");

        // file inbound adapter
        final FileReadingMessageSource fileReadingMessageSource = Files.inboundAdapter(folder)
                .autoCreateDirectory(true)
                .get();

        // rsocket outbound gateway
        final RSocketOutboundGatewaySpec rsocket = RSockets
                .outboundGateway("greetings")
                .interactionModel(RSocketInteractionModel.requestStream)
                .clientRSocketConnector(connector)
                .expectedResponseType(GreetingResponse.class);

        return IntegrationFlows.from(fileReadingMessageSource,
                pmc -> pmc.poller(pm -> pm.fixedRate(1_000))) // poll every second
                .transform(new FileToStringTransformer())
                .transform(String.class, name -> new GreetingRequest(name.trim()))
                .handle(rsocket) // send to RSocket
                .split() // split does also subscribe, therefore all following components should understant Backpressure
                .channel(reactiveMessageChanel())
                .handle(new GenericHandler<GreetingResponse>() {
                    @Override
                    public Object handle(final GreetingResponse greetingResponse, final MessageHeaders messageHeaders) {
                        System.out.println("new message: " + greetingResponse.toString());
                        // returning null tells spring integration to stop processing
                        return null;
                    }
                })
                .get();
    }

    @Bean
    ClientRSocketConnector clientRSocketConnector(final RSocketStrategies strategies) {
        final ClientRSocketConnector connector = new ClientRSocketConnector("localhost", 8888);
        connector.setRSocketStrategies(strategies);
        return connector;
    }

    @Bean
    MessageChannel reactiveMessageChanel() {
        return MessageChannels.flux().get();
    }

}
