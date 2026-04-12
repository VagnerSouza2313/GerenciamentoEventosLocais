package com.vagner.EventClean.infra.controllers;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.usecases.BuscarEventoCase;
import com.vagner.EventClean.core.usecases.CriarEventoCase;
import com.vagner.EventClean.core.usecases.FiltroIdentificadorCase;
import com.vagner.EventClean.infra.dtos.EventDTO;
import com.vagner.EventClean.infra.mappers.EventDTOMapper;
import com.vagner.EventClean.infra.persistence.EventEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CriarEventoCase criarEventoCase;
    private final BuscarEventoCase buscarEventoCase;
    private final FiltroIdentificadorCase filtroIdentificadorCase;
    private final EventDTOMapper eventDTOMapper;

    public EventController(CriarEventoCase criarEventoCase, BuscarEventoCase buscarEventoCase, FiltroIdentificadorCase filtroIdentificadorCase, EventDTOMapper eventDTOMapper) {
        this.criarEventoCase = criarEventoCase;
        this.buscarEventoCase = buscarEventoCase;
        this.filtroIdentificadorCase = filtroIdentificadorCase;
        this.eventDTOMapper = eventDTOMapper;
    }

    @PostMapping("criarEvento")
    public EventDTO criarEvento(@RequestBody EventDTO eventDTO){
        Event novoEvento = criarEventoCase.execute(eventDTOMapper.toDomain(eventDTO));
        return eventDTOMapper.toDto(novoEvento);

    }

    @GetMapping("listaEventos")
    public ResponseEntity<Map<String, Object>> listarEventos(){
        List<Event> list = buscarEventoCase.execute();
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("Message: ", "lista de eventos carregada com sucesso!");
        resultado.put("Dados dos eventos: ", list.stream()
                .map(eventDTOMapper::toDto)
                .collect(Collectors.toList()));
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("evento/{identificador}")
    public ResponseEntity<Map<String, Object>> buscarPorId(@PathVariable String identificador){
        Event event = filtroIdentificadorCase.execute(identificador);

        Map<String, Object> result = new HashMap<>();
        result.put("message", "Evento encontrado com sucesso!");
        result.put("dados", eventDTOMapper.toDto(event));

        return ResponseEntity.ok(result);
    }


}
