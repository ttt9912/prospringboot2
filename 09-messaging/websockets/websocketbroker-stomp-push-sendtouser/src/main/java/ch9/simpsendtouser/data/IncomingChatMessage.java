package ch9.simpsendtouser.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class IncomingChatMessage {
    String to;
    String text;

    @JsonCreator
    public IncomingChatMessage(
            @JsonProperty("to") final String to,
            @JsonProperty("text") final String text) {
        this.to = to;
        this.text = text;
    }
}
