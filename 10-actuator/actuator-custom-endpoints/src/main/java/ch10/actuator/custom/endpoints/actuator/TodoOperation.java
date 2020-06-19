package ch10.actuator.custom.endpoints.actuator;

import lombok.Value;

@Value
public class TodoOperation {
    private String name;
    private boolean successful;
}
