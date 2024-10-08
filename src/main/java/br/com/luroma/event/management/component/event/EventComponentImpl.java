package br.com.luroma.event.management.component.event;

import br.com.luroma.event.management.domain.Event;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
class EventComponentImpl implements EventComponent{
    private final EventRepository eventRepository;

    public EventComponentImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(EventEntity.fromDomainModel(event)).toDomainModel();
    }

    @Override
    public List<Event> getEvents() {
        return StreamSupport.stream(eventRepository.findAll().spliterator(), true)
                .map(EventEntity::toDomainModel).toList();
    }

    @Override
    public void addUserToEvent(String eventId, String userId) {
        //TODO
    }
}
