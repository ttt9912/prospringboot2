package ch9.simpsendtouser.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class OutgoingChatMessage {
    String from;
    String text;

    @JsonCreator
    public OutgoingChatMessage(
            @JsonProperty("from") final String from,
            @JsonProperty("text") final String text) {
        this.from = from;
        this.text = text;
    }
}
