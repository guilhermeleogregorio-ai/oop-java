package org.guilherme.ifsp.exercises.Prova2.model;

import java.util.Objects;

public class Despesa {
    private int id;
    private String descricao;
    private double valor;
    private String cnpj;

    public Despesa(int id, double valor, String descricao, String cnpj) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.cnpj = cnpj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Despesa despesa = (Despesa) o;
        return getId() == despesa.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Despesa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
