package webflux.routing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import webflux.handler.ToDoHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/*
 * Functional endpoint
 *
 * Alternative: use annotated controllers like spring web (--> see 'webflux-tests' module)
 */
@Configuration
public class ToDoRoutingConfig {

    @Bean
    RouterFunction<ServerResponse> monoRouterFunction(ToDoHandler toDoHandler) {
        return route(GET("/todo").and(accept(APPLICATION_JSON)), toDoHandler::getToDos)
                .andRoute(GET("/todo/{id}").and(accept(APPLICATION_JSON)), toDoHandler::getToDo);
    }
}
