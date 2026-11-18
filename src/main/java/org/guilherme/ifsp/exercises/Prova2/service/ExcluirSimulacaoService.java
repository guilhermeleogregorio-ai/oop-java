package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.model.Declaracao;
import org.guilherme.ifsp.exercises.Prova2.model.DeclaracaoCompleta;
import org.guilherme.ifsp.exercises.Prova2.model.DeclaracaoSimplificada;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;

import java.util.NoSuchElementException;

public class ExcluirSimulacaoService {
    private final DeclaracaoDAO dao;

    public ExcluirSimulacaoService(DeclaracaoDAO dao){
        this.dao = dao;
    }

    public void excluir(int id){
        final DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.buscarPorId(1).orElseThrow(() -> new NoSuchElementException("Simulacao não encintrada"));
        final DeclaracaoSimplificada simplificada = (DeclaracaoSimplificada) dao.buscarPorId(1).orElseThrow(() -> new NoSuchElementException("Simulacao não encintrada"));

        dao.remover();

    }
}
