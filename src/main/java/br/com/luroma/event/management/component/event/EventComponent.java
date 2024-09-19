package br.com.luroma.event.management.component.event;

import br.com.luroma.event.management.domain.Event;

import java.util.List;

public interface EventComponent {
    Event createEvent(Event event);
    List<Event> getEvents();
    void addUserToEvent(String eventId, String userId);
}
