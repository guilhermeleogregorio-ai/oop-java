package org.guilherme.ifsp.exercises.ListaParaP2.modulo_a.a1;

public class Produto {
    private final String nome;
    private final double preco;
    static int total;


    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        total++;
        if(preco < 0 ){
            throw new IllegalArgumentException(" Valor negativo");
        }
    }

    static int getTotal(){
        return total;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("Produto[nome = " + getNome() + " preço = " + getPreco() + "]");
    }


}
