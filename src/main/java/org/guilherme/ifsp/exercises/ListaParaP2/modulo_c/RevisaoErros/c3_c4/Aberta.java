package org.guilherme.ifsp.exercises.ListaParaP2.modulo_c.RevisaoErros.c3_c4;

public class Aberta implements EstadosPorta{
    private final Porta porta;

    public Aberta(Porta porta) {
        this.porta = porta;
    }

    @Override
    public void abrir() {
        throw new AcaoInvalidaException("A porta já está aberta ");
    }

    @Override
    public void fechar() {
        this.porta.setEstadosPorta(new Fechada(porta));
    }

    @Override
    public void trancar() {
        throw new AcaoInvalidaException("A porta está aberta não é possivel trancar");
    }

    @Override
    public void destrancar() {
        throw new AcaoInvalidaException("A porta está aberta não é possivel destrancar");
    }
}
