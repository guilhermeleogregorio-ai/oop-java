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

    public void adicionar(int id, double valor, String descricao, String cnpj, String info, String tipo) {
        final DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.buscarPorId(id)
                .orElseThrow(() -> new IllegalStateException("Simulação não iniciada"));

        Despesa despesa = (tipo == TipoDespesa.EDUCACAO)
                ? new DespesaEducacao(id,valor,descricao,cnpj,info)
                : new DespesaSaude(id, valor,descricao,cnpj,info);

        completa.adicionarDespesa(despesa);
        dao.salvar(despesa);

        // Próximos passos: instanciar a despesa conforme o 'tipo', adicionar em 'completa' e atualizar no 'dao'
    }
}
