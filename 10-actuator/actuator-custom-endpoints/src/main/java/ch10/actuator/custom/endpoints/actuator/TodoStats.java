package ch10.actuator.custom.endpoints.actuator;

import lombok.Value;

@Value
public class TodoStats {
    private long count;
    private long completed;
}
