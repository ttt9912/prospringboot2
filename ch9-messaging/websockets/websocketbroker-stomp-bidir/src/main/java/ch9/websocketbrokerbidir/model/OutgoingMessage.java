package ch9.websocketbrokerbidir.model;

import lombok.Value;

@Value
public class OutgoingMessage {
    String from;
    String content;
    String createdAt;
}