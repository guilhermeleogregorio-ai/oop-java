package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;

public class NovaSimulacaoService {
    private final DeclaracaoDAO dao;

    public NovaSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }
}
