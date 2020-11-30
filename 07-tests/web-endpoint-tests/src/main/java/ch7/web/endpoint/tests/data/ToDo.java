package ch7.web.endpoint.tests.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDo implements Serializable {
    private String id;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Boolean completed;
}
