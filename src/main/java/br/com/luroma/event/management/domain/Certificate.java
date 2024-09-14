package br.com.luroma.event.management.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Certificate {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String userId;
    private String eventId;

    public Certificate() {
    }

    public Certificate(String userId, String eventId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //    t.string "authenticity_key"
//    t.string "participant_name"
//    t.date "event_starting_date"
//    t.date "event_end_date"
//    t.string "event_name"
//    t.integer "event_duration"
//    t.string "event_location"
//    t.integer "certificate_model_id"
//    t.integer "event_participant_id"
//    t.datetime "created_at", null: false
//    t.datetime "updated_at", null: false
//    t.string "event_type"
//    t.string "participant_type"
//    t.string "event_period"
}
