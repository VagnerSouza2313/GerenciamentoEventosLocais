package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;

public class criarEventoCaseImpl implements criarEventoCase{


    @Override
    public Event execute(Event evento) {
        return evento;
    }
}
