package edurion.uithymeleaf.edutask;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class EdutaskDto {
    private String key;

    @NotBlank(message = "Title is required")
    private String title;
    private Boolean completed;
}
