package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.ListaDeTarefas;

import java.time.LocalDate;
import java.util.Objects;

public class Tarefa implements Comparable<Tarefa>{
    private String titulo;
    private int prioridade;
    private LocalDate prazo;
    private boolean concluida;

    public Tarefa(String titulo, int prioridade, LocalDate prazo) {
        this.titulo = titulo;
        this.prioridade = prioridade;
        this.prazo = prazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public boolean isConcluida(){
        return concluida;
    }

    public void concluir(){
        concluida = true;
    }

    @Override
    public int compareTo(Tarefa outra) {
        int compararData = this.prazo.compareTo(outra.getPrazo());
        if(compararData != 0) {
            return compararData;
        }
        int compararPrioridade = Integer.compare(outra.prioridade,this.prioridade);
        if(compararPrioridade != 0){
            return compararPrioridade;
        }
        return this.titulo.compareTo(outra.titulo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(titulo, tarefa.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    @Override
    public String toString() {
        return String.format("%s (p%d, %s)",titulo,prioridade,prazo,concluida ? ", ok" : "");
    }
}
