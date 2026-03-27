package com.vagner.EventClean.infra.controllers;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.usecases.CriarEventoCase;
import com.vagner.EventClean.infra.dtos.EventDTO;
import com.vagner.EventClean.infra.mappers.EventDTOMapper;
import com.vagner.EventClean.infra.persistence.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CriarEventoCase criarEventoCase;
    private final EventDTOMapper eventDTOMapper;

    public EventController(CriarEventoCase criarEventoCase, EventDTOMapper eventDTOMapper) {
        this.criarEventoCase = criarEventoCase;
        this.eventDTOMapper = eventDTOMapper;
    }

    @PostMapping("criarEvento")
    public EventDTO criarEvento(@RequestBody EventDTO eventDTO){
        Event novoEvento = criarEventoCase.execute(eventDTOMapper.toDomain(eventDTO));
        return eventDTOMapper.toDto(novoEvento);

    }

    @GetMapping("listaEventos")
    public String listarEventos(){
        return "listando eventos";
    }


    //TODO FAZER O FUNCIONAL DO LISTAR EVENTOS

}
