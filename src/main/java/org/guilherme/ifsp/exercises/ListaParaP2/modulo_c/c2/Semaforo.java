package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c2;

public class Semaforo {
    private SemaforoStates estadoAtual;
    private int ciclo;

    public Semaforo() {
        this.estadoAtual = new Verde(this);
        this.ciclo = 0;
    }

    public void setEstado(SemaforoStates novoEstado) {
        this.estadoAtual = novoEstado;
    }

    public void avancar() {
        estadoAtual.avancar();
    }

    public void incrementarCiclos() {
        this.ciclo++;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void imprimirEstado(){
        System.out.println("Estado atual: " + estadoAtual + "| Ciclos completos: " + ciclo);
    }


}
