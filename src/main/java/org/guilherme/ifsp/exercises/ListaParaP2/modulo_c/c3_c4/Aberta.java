package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.c3_c4;

public class Aberta implements StatesDoor {
    private Porta porta;
    public Aberta(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        throw new AcaoInvalidaException("A porta já está aberta");
    }

    @Override
    public void fechar() {
        porta.setStatesDoor(new Fechada(porta));
    }

    @Override
    public void trancar() {
        throw new AcaoInvalidaException("A porta não pode ser trancada pois está aberta. Feche a porta!");
    }

    @Override
    public void destrancar() {
        throw new AcaoInvalidaException("A porta não está trancada");
    }

    @Override
    public String toString() {
        return "Aberta";
    }
}
