package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c2;

class Vermelho implements SemaforoStates {
    private Semaforo semaforo;

    Vermelho(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void avancar() {
        System.out.println("Semaforo está vermelho!\n");
        this.semaforo.setEstado(new Verde(semaforo));
        semaforo.incrementarCiclos();
    }

    @Override
    public String toString() {
        return "Vermelho";
    }
}
