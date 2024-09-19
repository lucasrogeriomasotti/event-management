package br.com.luroma.event.management.component.event;

import org.springframework.data.repository.CrudRepository;

interface EventRepository extends CrudRepository<EventEntity, String> {
}
