package br.com.luroma.event.management.web;

import br.com.luroma.event.management.component.event.EventComponent;
import br.com.luroma.event.management.domain.Certificate;
import br.com.luroma.event.management.domain.Event;
import br.com.luroma.event.management.web.requests.CreateCertificateRequest;
import br.com.luroma.event.management.web.requests.CreateEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventComponent eventComponent;

    @GetMapping
    public List<Event> list() {
        return eventComponent.getEvents();
    }

    @PostMapping
    public Event create(@RequestBody CreateEventRequest request) {
        return eventComponent.createEvent(request.toEvent());
    }
}
