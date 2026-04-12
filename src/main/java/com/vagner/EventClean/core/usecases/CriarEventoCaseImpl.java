package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;
import com.vagner.EventClean.core.gateway.EventGateway;
import com.vagner.EventClean.infra.exceptions.DuplicateEventException;

public class CriarEventoCaseImpl implements CriarEventoCase {

    private final EventGateway eventGateway;

    public CriarEventoCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event evento) {
        if (eventGateway.existePorIdentificador(evento.getIdentificar())){
            throw new DuplicateEventException("O identificador numero: " + evento.getIdentificar() + " já está em uso para outro evento.");
        }
        return eventGateway.criarEvento(evento);
    }
}
