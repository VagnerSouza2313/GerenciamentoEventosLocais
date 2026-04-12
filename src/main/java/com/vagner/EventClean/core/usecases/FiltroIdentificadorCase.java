package com.vagner.EventClean.core.usecases;

import com.vagner.EventClean.core.entities.Event;

import java.util.List;

public interface FiltroIdentificadorCase {

    public Event execute(String identificador);

}
