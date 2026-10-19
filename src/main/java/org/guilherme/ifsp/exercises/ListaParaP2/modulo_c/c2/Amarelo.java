package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c2;

class Amarelo implements SemaforoStates {
    private Semaforo semaforo;

    Amarelo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void avancar() {
        System.out.println("Semaforo está amarelo\n");
        this.semaforo.setEstado(new Vermelho(semaforo));
    }

    @Override
    public String toString() {
        return "Amarelo";
    }
}
