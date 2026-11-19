package org.guilherme.ifsp.exercises.TreinoPOO.ContaDeBanco;

public class ContaCorrente extends ContaBanco{

    public ContaCorrente(int numConta, String dono) {
        super(numConta, dono, TipoConta.CORRENTE, 0.0);
    }


}
