package ch10.actuator.metrics.intercept;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * HandlerInterceptor - intercept REST calls
 * - offers three methods: preHandle(), postHandle(), afterCompletition()
 *
 * MeterRegistry - add metrics to micrometer
 *
 * NOTE: HandlerInterceptor has nothing to do with Metrics
 *
 */
@Slf4j
public class TodoMetricHandlerInterceptor implements HandlerInterceptor {
    private final MeterRegistry meterRegistry;

    public TodoMetricHandlerInterceptor(final MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex) {
        final String uri = request.getRequestURI();
        final String method = request.getMethod();
        final String pathKey = "api_".concat(method.toLowerCase()).concat(uri.toLowerCase());

        log.info("TodoMetricHandlerInterceptor >> URI: {} METHOD: {}", uri, method);
        meterRegistry.counter(pathKey).increment();
    }
}
