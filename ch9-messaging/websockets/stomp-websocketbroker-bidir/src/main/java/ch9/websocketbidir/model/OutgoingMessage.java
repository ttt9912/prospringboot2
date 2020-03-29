package ch9.websocketbidir.model;

import lombok.Value;

@Value
public class OutgoingMessage {
    String from;
    String content;
    String createdAt;
}
