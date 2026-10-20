package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c2;

class Verde implements SemaforoStates {
    private Semaforo semaforo;

    Verde(Semaforo semaforo){
        this.semaforo = semaforo;
    }
    public void avancar(){
        System.out.println("Semáforo esta verde!");
        semaforo.setEstado(new Amarelo(semaforo));
    }

    @Override
    public String toString() {
        return "Verde";
    }
}
