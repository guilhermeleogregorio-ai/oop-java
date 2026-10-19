package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c3_c4;

public class Fechada implements StatesDoor {
    private Porta porta;

    public Fechada(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        this.porta.setStatesDoor(new Aberta(porta));
        this.porta.incrementarContador();
    }

    @Override
    public void fechar() {
        throw new AcaoInvalidaException("A porta já está fechada!");
    }

    @Override
    public void trancar() {
        this.porta.setStatesDoor(new Trancada(porta));
    }

    @Override
    public void destrancar() {
        throw new AcaoInvalidaException("A porta não está trancada!");
    }

    @Override
    public String toString() {
        return "Fechada";
    }
}
