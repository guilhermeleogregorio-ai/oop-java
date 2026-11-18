package org.guilherme.ifsp.exercises.Prova2.model;

public class DeclaracaoSimplificada extends Declaracao {
    public DeclaracaoSimplificada(int id, double ganhoTributavel, double valorJaPago) {
        super(id, ganhoTributavel, valorJaPago);
    }

    @Override
    public double valorImposto() {
        double ganhoTributavel = getGanhoTributavel();
        double valorJaPago = getValorJaPago();
        double valorDoImposto = 0;
        if (ganhoTributavel > 22847.88) {
            valorDoImposto = (ganhoTributavel * 0.20) - valorJaPago;
        }
        return valorDoImposto;
    }


    @Override
    public String toString() {
        return "DeclaracaoSimplificada{} " + super.toString();
    }
}
