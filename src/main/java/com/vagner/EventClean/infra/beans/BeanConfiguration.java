package com.vagner.EventClean.infra.beans;

import com.vagner.EventClean.core.gateway.EventGateway;
import com.vagner.EventClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoCase criarEvento(EventGateway eventGateway){
        return new CriarEventoCaseImpl(eventGateway);
    }

    @Bean
    public BuscarEventoCase buscarEvento(EventGateway eventGateway){
        return new BuscarEventoCaseImpl(eventGateway);
    }

    @Bean
    public FiltroIdentificadorCase filtrarEvento(EventGateway eventGateway){
        return new FiltroIdentificadorCaseImpl(eventGateway);
    }

}
