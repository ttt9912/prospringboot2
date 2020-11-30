package ch9.stomptesting.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class ChatMessage {
    String from;
    String text;

    public ChatMessage(@JsonProperty("from") final String from,
                       @JsonProperty("text") final String text) {
        this.from = from;
        this.text = text;
    }
}
