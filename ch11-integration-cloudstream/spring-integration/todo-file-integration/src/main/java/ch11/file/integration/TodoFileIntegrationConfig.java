package ch11.file.integration;

import ch11.file.integration.messageendpoints.TodoConverter;
import ch11.file.integration.properties.TodoFileProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.file.dsl.FileInboundChannelAdapterSpec;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.splitter.FileSplitter;

import java.io.File;

/*
 *  # FileInboundChannelAdapterSpec
 *  - input message source
 *  - implementation of MessageSourceSpec
 *
 *  # IntegrationFlow
 *  - from() accepts various types of message sources
 *  - chains MessageEndpoints stream-like
 */
@EnableConfigurationProperties(TodoFileProperties.class)
@Configuration
public class TodoFileIntegrationConfig {
    private final TodoFileProperties fileProperties;
    private final TodoConverter todoConverter;

    public TodoFileIntegrationConfig(final TodoFileProperties fileProperties, final TodoConverter todoConverter) {
        this.fileProperties = fileProperties;
        this.todoConverter = todoConverter;
    }

    /*
     * file message source
     */
    public FileInboundChannelAdapterSpec fileSource() {
        return Files.inboundAdapter(new File(this.fileProperties.getDirectory()))
                .preventDuplicates(true)
                .patternFilter(fileProperties.getFilePattern());
    }

    @Bean
    public IntegrationFlow fileFlow() {
        return IntegrationFlows
                .from(fileSource(), e -> e.poller(Pollers.fixedDelay(5000L)))
                .split(Files.splitter().markers())
                .filter(p -> !(p instanceof FileSplitter.FileMarker))
                .transform(Transformers.converter(todoConverter))
                .handle("todoMessageHandler", "process").get();
    }

}
