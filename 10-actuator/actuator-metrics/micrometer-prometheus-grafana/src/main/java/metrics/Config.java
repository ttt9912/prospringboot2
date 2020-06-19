package metrics;

import io.micrometer.core.instrument.MeterRegistry;
import metrics.intercept.TodoMetricHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Configuration
public class Config {

    /*
     * register the TodoMetricHandlerInterceptor for every request (/**)
     *
     * NOTE: this has nothing to do with the monitoring itself
     * MeterRegistry is just injected because TodoMetricHandlerInterceptor is not a bean
     */
    @Bean
    public MappedInterceptor metricInterceptor(MeterRegistry meterRegistry) {
        return new MappedInterceptor(new String[]{"/**"}, new TodoMetricHandlerInterceptor(meterRegistry));
    }
}
