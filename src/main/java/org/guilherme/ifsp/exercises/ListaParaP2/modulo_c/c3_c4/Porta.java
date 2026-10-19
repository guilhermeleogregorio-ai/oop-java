package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c3_c4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Porta {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private StatesDoor estadoAtual;
    private int contadorAberta;
    private String evento = "";
    private final List<String> eventos = new ArrayList<>();


    public Porta() {
        this.estadoAtual = new Fechada(this);
        this.contadorAberta = 0;
    }

    public StatesDoor getStatesDoor() {
        return estadoAtual;
    }


    public void abrir()      { evento = "Abrir";      estadoAtual.abrir(); }
    public void fechar()     { evento = "Fechar";     estadoAtual.fechar(); }
    public void trancar()    { evento = "Trancar";    estadoAtual.trancar(); }
    public void destrancar() { evento = "Destrancar"; estadoAtual.destrancar(); }

    public void setStatesDoor(StatesDoor novo) {
        String de = estadoAtual.toString();
        estadoAtual = novo;
        log(de, novo.toString());
    }

    public void incrementarContador(){
        contadorAberta++;
    }
    public void imprimirEstado(){
        System.out.println("Estado atual da porta " + estadoAtual);
    }

    private void log(String form,String to){
        eventos.add(String.format("[%s] %s | %s => %s | Aberturas = %d",
                LocalDateTime.now().format(FMT), evento,form ,to,contadorAberta));

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String e: eventos){
            sb.append(e).append("\n");
        }
        return  sb.toString();
    }
}
