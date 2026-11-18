package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

public class DespesaEducacao extends Despesa{
    static final public double DECUCAO_MAX = 2000.0;
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
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DespesaEducacao that = (DespesaEducacao) o;
        return Objects.equals(getNomeInstituicao(), that.getNomeInstituicao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNomeInstituicao());
    }

    @Override
    public String toString() {
        return "DespesaEducacao{" +
                "nomeInstituicao='" + nomeInstituicao + '\'' +
                "} " + super.toString();
    }
}
