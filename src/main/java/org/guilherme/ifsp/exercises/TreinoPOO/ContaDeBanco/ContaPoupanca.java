package org.guilherme.ifsp.exercises.TreinoPOO.ContaDeBanco;

public class ContaPoupanca extends ContaBanco {
    public ContaPoupanca(int numConta, String dono) {
        super(numConta, dono, TipoConta.POUPANCA , 0.0);
    }

    @Override
    public void abrirConta() {
        super.abrirConta();
        this.setSaldo(150.0);
    }

    @Override
    public void pagarMensal() {
        super.pagarMensal();
        this.sacar(20.0);
    }
}
