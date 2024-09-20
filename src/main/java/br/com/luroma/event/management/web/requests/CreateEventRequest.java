package br.com.luroma.event.management.web.requests;

import br.com.luroma.event.management.domain.Event;

import java.util.Date;
import java.util.Set;

public record CreateEventRequest(String name, String description, Date startDate, Date endDate, Set<String> participants) {
    public Event toEvent() {
        Event event = new Event();
        event.setName(name);
        event.setDescription(description);
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setParticipants(participants);
        return event;
    }
}