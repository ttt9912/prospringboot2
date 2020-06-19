package ch9.stompecho.data;

import lombok.Value;

@Value
public class ChatMessage {
    String from;
    String text;
}
