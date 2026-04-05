package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.gateway.EventGateway;

import java.util.List;

public class BuscarEventoCaseImpl implements BuscarEventoCase {

    private final EventGateway eventGateway;

    public BuscarEventoCaseImpl(EventGateway eventGateway1) {
        this.eventGateway = eventGateway1;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.listarEventos();
    }
}
