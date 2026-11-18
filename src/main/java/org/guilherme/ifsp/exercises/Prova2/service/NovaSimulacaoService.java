package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.exception.EntityAlreadyExists;
import org.guilherme.ifsp.exercises.Prova2.model.DeclaracaoCompleta;
import org.guilherme.ifsp.exercises.Prova2.model.DeclaracaoSimplificada;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;

public class NovaSimulacaoService {
    private final DeclaracaoDAO dao;

    public NovaSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public void iniciar(double ganhoTributavel , double valorJaPago){
        if(dao.buscarPorId(1).isPresent())
            throw  new EntityAlreadyExists("Simualacao já iniciada");

        final DeclaracaoCompleta completa = new DeclaracaoCompleta(1, ganhoTributavel, valorJaPago);
        final DeclaracaoSimplificada simplificada = new DeclaracaoSimplificada(1, ganhoTributavel,valorJaPago);

         dao.salvar(completa);
         dao.salvar(simplificada);
    }
}
