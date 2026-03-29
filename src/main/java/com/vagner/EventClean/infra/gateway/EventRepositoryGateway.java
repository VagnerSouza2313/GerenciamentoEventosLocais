package com.vagner.EventClean.infra.gateway;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.gateway.EventGateway;
import com.vagner.EventClean.infra.mappers.EventEntityMapper;
import com.vagner.EventClean.infra.persistence.EventEntity;
import com.vagner.EventClean.infra.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventRepositoryGateway implements EventGateway {

    private EventRepository eventRepository;
    private EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event criarEvento(Event evento) {
        EventEntity entity = eventEntityMapper.toEventEntity(evento);
        EventEntity novoEvent = eventRepository.save(entity);
        return eventEntityMapper.toEvent(novoEvent);
    }

    @Override
    public List<Event> listarEventos() {
        List<EventEntity> lista = eventRepository.findAll();
        List<Event> collect = lista.stream()
                .map(eventEntityMapper::toEvent).collect(Collectors.toList());
        return collect;
    }
}
