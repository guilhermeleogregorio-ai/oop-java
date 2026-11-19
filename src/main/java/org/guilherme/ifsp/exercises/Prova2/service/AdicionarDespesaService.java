package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.model.DeclaracaoCompleta;
import org.guilherme.ifsp.exercises.Prova2.model.Despesa;
import org.guilherme.ifsp.exercises.Prova2.model.DespesaEducacao;
import org.guilherme.ifsp.exercises.Prova2.model.DespesaSaude;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;

public class AdicionarDespesaService {
    private final DeclaracaoDAO dao;

    public AdicionarDespesaService(DeclaracaoDAO dao) {
        this.dao = dao;
    }

    public void adicionar(int idDespesa, double valor, String descricao,
                          String cnpj, String info, TipoDespesa tipo) {
        DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.buscarPorId(1)
                .orElseThrow(() -> new IllegalStateException("Simulação não iniciada"));

        Despesa despesa = (tipo == TipoDespesa.EDUCACAO)
                ? new DespesaEducacao(idDespesa, valor, descricao, cnpj, info)
                : new DespesaSaude(idDespesa, valor, descricao, cnpj, info);

        completa.adicionarDespesa(despesa);
        dao.atualizar(completa);
    }
}
