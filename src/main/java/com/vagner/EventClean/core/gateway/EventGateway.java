package com.vagner.EventClean.core.gateway;

import com.vagner.EventClean.core.entities.Event;

import java.util.List;

public interface EventGateway {

    Event criarEvento(Event evento);

    List<Event> listarEventos();

}
