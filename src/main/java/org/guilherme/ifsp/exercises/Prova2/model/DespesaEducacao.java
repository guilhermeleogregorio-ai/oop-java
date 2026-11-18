package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

public class DespesaEducacao extends Despesa{
    static final public double DEDUCAO_MAX = 2000.0;
    private String nomeInstituicao;

    public DespesaEducacao(int id, double valor, String descricao, String cnpj, String nomeInstituicao) {
        super(id, valor, descricao, cnpj);
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    @Override
    public String toString() {
        return "DespesaEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                "} " + super.toString();
    }
}
