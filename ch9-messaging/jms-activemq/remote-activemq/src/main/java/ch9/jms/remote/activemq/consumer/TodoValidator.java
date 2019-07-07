package ch9.jms.remote.activemq.consumer;

import common.todo.data.jpa.todo.Todo;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TodoValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return clazz.isAssignableFrom(Todo.class);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        Todo todo = (Todo) target;

        if (todo == null) {
            errors.reject(null, "Todo cannot be null");
            return;
        }

        if (todo.getDescription() == null || todo.getDescription().isEmpty()) {
            errors.rejectValue("description", null,
                    "description cannot be null or empty");
        }
    }
}
