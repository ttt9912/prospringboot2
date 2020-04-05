package ch9.stompecho.inbound;

import lombok.Value;

@Value
public class ChatMessage {
    String from;
    String text;
}
