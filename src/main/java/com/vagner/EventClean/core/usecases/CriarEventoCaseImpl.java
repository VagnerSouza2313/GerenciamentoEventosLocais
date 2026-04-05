package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.gateway.EventGateway;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventGateway eventGateway;

    public CriarEventoCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event evento) {
        return eventGateway.criarEvento(evento);
    }
}
