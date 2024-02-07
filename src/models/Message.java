package models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPeerFromId() {
        return peerFromId;
    }

    public void setPeerFromId(UUID peerFromId) {
        this.peerFromId = peerFromId;
    }

    public UUID getPeerToId() {
        return peerToId;
    }

    public void setPeerToId(UUID peerToId) {
        this.peerToId = peerToId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private UUID id;
    private UUID peerFromId;
    private UUID peerToId;
    private LocalDateTime timestamp;
    private String body;
}
