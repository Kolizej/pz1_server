package models;

import java.time.LocalDateTime;

public class MessageDto {
    public String peerFromName;
    public String peerToName;
    private LocalDateTime timestamp;
    private String body;
}
