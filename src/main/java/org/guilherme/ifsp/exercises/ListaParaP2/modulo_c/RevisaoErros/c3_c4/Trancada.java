package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.RevisaoErros.c3_c4;

public class Trancada implements EstadosPorta{
    private Porta porta;

    public Trancada(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        throw new AcaoInvalidaException("A porta está trancada ");
    }

    @Override
    public void fechar() {
        throw new AcaoInvalidaException("A porta está trancada");
    }

    @Override
    public void trancar() {
        throw new AcaoInvalidaException("A porta já está trancada");
    }

    @Override
    public void destrancar() {
        this.porta.setEstadosPorta(new Fechada(porta));
    }

    @Override
    public String toString() {
        return "Trancada";
    }
}
