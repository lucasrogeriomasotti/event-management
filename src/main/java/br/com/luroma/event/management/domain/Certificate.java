package br.com.luroma.event.management.domain;

public class Certificate {
    private String id;
    private String userId;
    private String eventId;

    public Certificate(String id, String userId, String eventId) {
        this.id = id;
        this.userId = userId;
        this.eventId = eventId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}
