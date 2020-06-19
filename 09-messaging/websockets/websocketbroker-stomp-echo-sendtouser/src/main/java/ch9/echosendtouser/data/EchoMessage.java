package ch9.echosendtouser.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class EchoMessage {
    String text;

    @JsonCreator
    public EchoMessage(@JsonProperty("text") final String text) {
        this.text = text;
    }
}
