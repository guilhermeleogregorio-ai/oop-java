package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDaoImpl;

public class NovaSimulacaoService {
    private final DeclaracaoDaoImpl dao;

    public NovaSimulacaoService(DeclaracaoDaoImpl dao){
        this.dao = dao;
    }
}
