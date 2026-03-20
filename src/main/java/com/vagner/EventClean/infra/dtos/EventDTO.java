package com.vagner.EventClean.infra.dtos;

import com.vagner.EventClean.core.enuns.TipoEvento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record EventDTO(Long id,
                       String nome,
                       String descricao,
                       LocalDateTime data_inicio,
                       LocalDateTime data_fim,
                       String identificador,
                       String local_evento,
                       Integer capacidade,
                       String organizador,
                       TipoEvento tipo) {
}
