package br.com.luroma.event.management.domain;

import java.util.Date;
import java.util.Set;

public class Event {
    private String id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Set<String> participants;

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
