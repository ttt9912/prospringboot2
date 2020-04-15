package common.todo.rest;

import common.todo.data.jpa.CommonTodoDataJpaConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(CommonTodoDataJpaConfig.class)
public class CommonTodoRestConfig {
}
