package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.RevisaoErros.c3_c4;

public class Fechada implements EstadosPorta{
    private final Porta porta;

    public Fechada(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        this.porta.setEstadosPorta(new Aberta(porta));
        this.porta.incrementaContador();

    }

    @Override
    public void fechar() {
        throw new AcaoInvalidaException("A porta já está fechada");
    }

    @Override
    public void trancar() {
        this.porta.setEstadosPorta(new Trancada(porta));
    }

    @Override
    public void destrancar() {
        throw new AcaoInvalidaException("A porta não está trancada");
    }
}
