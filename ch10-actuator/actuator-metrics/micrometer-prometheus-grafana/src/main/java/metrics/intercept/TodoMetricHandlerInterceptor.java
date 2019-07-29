package metrics.intercept;

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
 * ---------------------------------------------------------------------------------
 * What does MeterRegistry expose?
 * ---------------------------------------------------------------------------------
 * - a counter for each rest endpoint under /actuator/prometheus
 * - also includes /actuator calls
 *
 * - api_get_api_todos_total
 * - api_get_actuator_total
 * - api_get_actuator_prometheus_total
 * - api_get_actuator__total
 * - ...
 *
 * NOTE: metrics for endpoints are listed after the endpoint was called for the
 * first time
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
