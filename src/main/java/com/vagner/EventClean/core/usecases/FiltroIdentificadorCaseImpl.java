package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.gateway.EventGateway;

import java.util.List;

public class FiltroIdentificadorCaseImpl implements FiltroIdentificadorCase {

    private final EventGateway eventGateway;

    public FiltroIdentificadorCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Event execute(String identificador) {
        return eventGateway.filtroIdentificador(identificador);
    }
}
