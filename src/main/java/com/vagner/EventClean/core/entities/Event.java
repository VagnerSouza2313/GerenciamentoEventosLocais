package com.vagner.EventClean.core.entities;

import com.vagner.EventClean.core.enuns.TipoEvento;

import java.time.LocalDateTime;

public class Event {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private String identificar;
    private String local;
    private Integer capacidade;
    private String organizador;
    private TipoEvento tipo;



}
