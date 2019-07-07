package ch9.jms.pointtopoint.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ErrorHandler;

@Slf4j
public class TodoErrorHandler implements ErrorHandler {

    @Override
    public void handleError(final Throwable t) {
        log.warn("Todo ERROR > {}", t.getCause().getMessage());
    }
}
