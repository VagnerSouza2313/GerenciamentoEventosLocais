package com.vagner.EventClean.infra.persistence;

import com.vagner.EventClean.core.enuns.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Eventos")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private LocalDateTime data_inicio;
    private LocalDateTime data_fim;
    private String identificar;
    private String local_evento;
    private Integer capacidade;
    private String organizador;
    @Enumerated(EnumType.STRING)
    private TipoEvento tipo;

}
