package ch4.client.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.Charset;

/*
 * DefaultResponseErrorHandler - provided to the RestTemplate (Config)
 *
 * If server returns 400, we can catch the error and react to it
 */
@Slf4j
public class ToDoErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public void handleError(final ClientHttpResponse response) throws IOException {
        log.error(response.getStatusCode().toString());
        log.error(StreamUtils.copyToString(response.getBody(), Charset.defaultCharset()));
    }
}
