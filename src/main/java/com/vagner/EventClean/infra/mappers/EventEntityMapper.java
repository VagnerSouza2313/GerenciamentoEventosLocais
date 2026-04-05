package com.vagner.EventClean.infra.mappers;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEventEntity(Event evento){
        return new EventEntity(
                evento.getId(),
                evento.getNome(),
                evento.getDescricao(),
                evento.getInicio(),
                evento.getFim(),
                evento.getIdentificar(),
                evento.getLocal(),
                evento.getCapacidade(),
                evento.getOrganizador(),
                evento.getTipo()
        );
    }

    public Event toEvent(EventEntity eventEntity){
        Event event = new Event();
        event.setId(eventEntity.getId());
        event.setNome(eventEntity.getNome());
        event.setDescricao(eventEntity.getDescricao());
        event.setInicio(eventEntity.getData_inicio());
        event.setFim(eventEntity.getData_fim());
        event.setIdentificar(eventEntity.getIdentificador());
        event.setLocal(eventEntity.getLocal_evento());
        event.setCapacidade(eventEntity.getCapacidade());
        event.setOrganizador(eventEntity.getOrganizador());
        event.setTipo(eventEntity.getTipo());
        return event;
    }

}
