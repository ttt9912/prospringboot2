package ch9.websocketbrokerbidir.model;

import lombok.Data;

@Data
public class IncomingMessage {
    private String from;
    private String content;
}
