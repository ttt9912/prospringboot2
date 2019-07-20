package aus.weather;

import aus.weather.business.WeatherService;
import com.forecasts.CommonForecastConfig;
import com.forecasts.CommonForecastService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/*
 * Scans the entire classpath on aus.weather
 * - aus.weather.business is included
 * - com.forecasts is not
 *
 * Scan beans from other base packages
 * - @Import
 * - scanBasePackages
 */
@SpringBootApplication // (scanBasePackages = {"aus.weather, com.forecasts"})
@Import(CommonForecastConfig.class)
public class WeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args).close();
    }

    @Bean
    public CommandLineRunner context(ApplicationContext applicationContext) {
        return args -> {
            System.out.println("WeatherService: " + applicationContext.getBeansOfType(WeatherService.class));
            System.out.println("CommonForecastService: " + applicationContext.getBeansOfType(CommonForecastService.class));
        };
    }
}
