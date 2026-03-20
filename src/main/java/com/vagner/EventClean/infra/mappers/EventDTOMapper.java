package com.vagner.EventClean.infra.mappers;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.infra.dtos.EventDTO;
import com.vagner.EventClean.infra.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventDTOMapper {

    public Event toDomain(EventDTO eventDTO){
        Event event = new Event();
        event.setId(eventDTO.id());
        event.setNome(eventDTO.nome());
        event.setDescricao(eventDTO.descricao());
        event.setInicio(eventDTO.data_inicio());
        event.setFim(eventDTO.data_fim());
        event.setIdentificar(eventDTO.identificador());
        event.setLocal(eventDTO.local_evento());
        event.setCapacidade(eventDTO.capacidade());
        event.setOrganizador(eventDTO.organizador());
        event.setTipo(eventDTO.tipo());
        return event;
    }

    public EventDTO toDto(Event event){
        return new EventDTO(
                event.getId(),
                event.getNome(),
                event.getDescricao(),
                event.getInicio(),
                event.getFim(),
                event.getIdentificar(),
                event.getLocal(),
                event.getCapacidade(),
                event.getOrganizador(),
                event.getTipo()
        );
    }


}
