package org.guilherme.ifsp.exercises.TreinoPOO.RelationshipBetweenClasses;

public class Lutador {
    private String nome;
    private String nacionalidade;
    private int idade;
    private double altura;
    private double peso;
    private String categoria;
    private int vitorias;
    private int derotas;
    private int empates;

    public Lutador(String nome, String nacionalidade, int idade, double altura, double peso, int vitorias, int derotas, int empates) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.vitorias = vitorias;
        this.derotas = derotas;
        this.empates = empates;
    }

    public void apresentar() {
        System.out.println("Nome :" + getNome());
        System.out.println("Nacionalidade :" + getNacionalidade());
        System.out.println("Idade :" + getIdade());
        System.out.println("Peso :" + getPeso());
        System.out.println("Categoria :" + getCategoria());
        System.out.println("Vitorias :" + getVitorias());
        System.out.println("Derrotas :" + getDerotas());
        System.out.println("Empates :" + getEmpates());

    }

    public void status() {
        System.out.println("Nome :" + getNome());
        System.out.println("Categoria :" + getCategoria());
        System.out.println("Vitorias :" + getVitorias());
        System.out.println("Derrotas :" + getDerotas());
        System.out.println("Empates :" + getEmpates());
    }

    public void ganharLuta() {
        this.setVitorias(this.getVitorias() + 1);
    }

    public void perdeLuta() {
        this.setDerotas(this.getDerotas() + 1);
    }

    public void empatarLuta() {
        this.setEmpates(this.getEmpates() + 1);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
        this.setCategoria();
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerotas() {
        return derotas;
    }

    public void setDerotas(int derotas) {
        this.derotas = derotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria() {
        if(peso < 52.2){
            categoria = "Inválido";
        } else if (peso <= 70.3) {
            categoria = "Leve";
        } else if (peso <= 83.9) {
            categoria = "Médio";
        } else if (peso <= 120.2) {
            categoria = "Pesado";
        } else {
            categoria = "Inválido";
        }
    }
}
