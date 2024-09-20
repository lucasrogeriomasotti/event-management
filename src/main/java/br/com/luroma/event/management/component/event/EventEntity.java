package br.com.luroma.event.management.component.event;

import br.com.luroma.event.management.domain.Event;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
class EventEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    @ElementCollection
    @CollectionTable(name = "event_users", joinColumns = @JoinColumn(name = "event_id"))
    @Column(name = "user_id")
    private Set<String> participants;

    public static EventEntity fromDomainModel(Event event) {
        EventEntity eventEntity = new EventEntity();
        eventEntity.setId(event.getId());
        eventEntity.setName(event.getName());
        eventEntity.setDescription(event.getDescription());
        eventEntity.setStartDate(event.getStartDate());
        eventEntity.setEndDate(event.getEndDate());
        eventEntity.setParticipants(event.getParticipants());
        return eventEntity;
    }

    public Event toDomainModel() {
        Event event = new Event();
        event.setId(getId());
        event.setName(getName());
        event.setDescription(getDescription());
        event.setStartDate(getStartDate());
        event.setEndDate(getEndDate());
        event.setParticipants(getParticipants());
        return event;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }
}
