package org.guilherme.ifsp.exercises.TreinoPOO.ContaDeBanco;

public class ContaPoupanca extends ContaBanco {
    public ContaPoupanca(int numConta, String dono) {
        super(numConta, dono, TipoConta.POUPANCA, 50.0);
    }
}
