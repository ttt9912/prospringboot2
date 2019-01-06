package ch4.todoapp.validation;

import org.springframework.validation.Errors;

/*
 * Creates a ToDoValidationError from given Spring Validation Errors
 *
 * Error -
 */
public class ToDoValidationErrorBuilder {

    public static ToDoValidationError fromBindingErrors(Errors errors) {
        ToDoValidationError toDoValidationError =
                new ToDoValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");

        errors.getAllErrors().forEach(error ->
                toDoValidationError.addValidationError(error.getDefaultMessage()));
        return toDoValidationError;
    }
}
