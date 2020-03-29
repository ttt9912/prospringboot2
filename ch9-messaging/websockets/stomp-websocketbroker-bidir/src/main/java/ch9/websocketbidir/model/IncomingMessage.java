package ch9.websocketbidir.model;

import lombok.Data;

@Data
public class IncomingMessage {
    private String from;
    private String content;
}
