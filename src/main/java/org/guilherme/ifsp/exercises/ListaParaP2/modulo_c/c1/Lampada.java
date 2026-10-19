package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c1;

public class Lampada {
    private LampadaState estadoAtual;

    public Lampada() {
        this.estadoAtual = new Apagada(this);
    }

    public void setEstado(LampadaState novoEstado){
        this.estadoAtual = novoEstado;
    }

    public void apertar(){
        estadoAtual.apertar();
    }

    public void imprimirEstado(){
        System.out.println("Estado atual = " + estadoAtual);
    }
}
