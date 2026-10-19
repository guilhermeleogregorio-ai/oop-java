package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c3_c4;

public class Trancada implements StatesDoor {
    private Porta porta;

    public Trancada(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        throw new AcaoInvalidaException("Destranque a porta para Abrir-lá!");
    }

    @Override
    public void fechar() {
        throw new AcaoInvalidaException("A porta já está fechada!");
    }

    @Override
    public void trancar() {
        throw new AcaoInvalidaException("A porta já está trancada!");
    }

    @Override
    public void destrancar() {
        this.porta.setStatesDoor(new Aberta(porta));
    }

    @Override
    public String toString() {
        return "Trancada";
    }
}
