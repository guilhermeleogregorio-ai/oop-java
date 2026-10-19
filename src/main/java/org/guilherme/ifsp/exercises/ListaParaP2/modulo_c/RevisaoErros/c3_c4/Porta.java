package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.RevisaoErros.c3_c4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Porta {
    private EstadosPorta estadosPorta;
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
    private String evento = "";
    private final List<String> eventos = new ArrayList<>();
    private int contatadorAberta;


    public void abrir() { evento = "Abrir";  estadosPorta.abrir();}
    public void fechar(){evento = "Fechar "; estadosPorta.fechar();}
    public  void trancar(){evento = "Trancar"; estadosPorta.trancar();}
    public void destrancar(){evento = "Destrancar"; estadosPorta.destrancar();}

    public Porta() {
        this.estadosPorta =  new Fechada(this);
        this.contatadorAberta = 0;
    }

    public void imprimirEstado(){
        System.out.println("Estado da porta: "+ estadosPorta);
    }

    public void setEstadosPorta(EstadosPorta novo) {
        log(estadosPorta.toString(), novo.toString());
        this.estadosPorta = novo;
    }

    public void incrementaContador(){
        this.contatadorAberta ++;
    }

    public void log(String de,String para){
        eventos.add(String.format("[%s] %s | %s => %s | Aberturas = %d ", LocalDateTime.now().format(FMT),evento,de,para,contatadorAberta));
    }

    public List<String> getEventos() {
        return eventos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String e : eventos) {sb.append(e).append("\n");}
        return sb.toString();
    }
}
