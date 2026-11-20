package org.guilherme.ifsp.exercises.TreinoPOO.Basic.ContaBanco;

public class Main {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(1,"Guilherme");
        ContaPoupanca p1 = new ContaPoupanca(1,"Guilherme");
        c1.abrirConta();
        p1.abrirConta();
        p1.depositar(1000.0);
        c1.depositar(1000.0);
        p1.pagarMensal();
        c1.pagarMensal();

        System.out.println(c1);
        System.out.println(p1);

    }
}
