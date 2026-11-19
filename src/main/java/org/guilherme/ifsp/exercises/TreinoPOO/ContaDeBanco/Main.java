package org.guilherme.ifsp.exercises.TreinoPOO.ContaDeBanco;

public class Main {
    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente(1,"Guilherme");
        ContaPoupanca p1 = new ContaPoupanca(1,"Guilherme");

        System.out.println(c1);
        System.out.println(p1);

    }
}
