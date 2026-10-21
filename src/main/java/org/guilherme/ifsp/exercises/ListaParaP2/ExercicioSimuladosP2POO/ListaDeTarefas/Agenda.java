package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.ListaDeTarefas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public boolean adicionar(Tarefa tarefa){
        if(tarefas.contains(tarefa)){
            return false;
        }else {
            tarefas.add(tarefa);
            return true;
        }
    }

    public boolean remover(String titulo) {
        Iterator<Tarefa> iterator = iterador();
        while (iterator.hasNext()) {
            Tarefa atual = iterator.next();
            if(atual.getTitulo().equals(titulo)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean concluir(String titulo){
        for(Tarefa tarefa: tarefas) {
            if (tarefa.getTitulo().equals(titulo)) {
                tarefa.concluir();
                return true;
            }
        }
        return false;
    }

    public Iterator<Tarefa> iterador(){
        return tarefas.iterator();
    }

    public List<Tarefa> ordenadas(){
        List<Tarefa> ordenadas = new ArrayList<>(tarefas);
        ordenadas.sort(Tarefa::compareTo);
        return ordenadas;
    }

    public List<Tarefa> porPrioridade(){
        List<Tarefa> porPrioridade = new ArrayList<>(tarefas);
        porPrioridade.sort((a,b) ->{
        int c = Integer.compare(b.getPrioridade(),a.getPrioridade());
        return c!= 0 ? c : a.getPrazo().compareTo(b.getPrazo());
        });
        return porPrioridade;
    }

    public List<Tarefa> atrasadas(LocalDate hoje){
        List<Tarefa> atrasadas = new ArrayList<>();
        for(Tarefa tarefa : tarefas){
            if(!tarefa.isConcluida() && tarefa.getPrazo().isBefore(hoje)) {
                atrasadas.add(tarefa);
            }
        }
        return atrasadas;
    }
}
