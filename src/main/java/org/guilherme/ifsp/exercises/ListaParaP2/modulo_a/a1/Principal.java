package org.guilherme.ifsp.exercises.ListaParaP2.modulo_a.a1;

import static org.guilherme.ifsp.exercises.ListaParaP2.modulo_a.a1.Produto.total;
import static org.guilherme.ifsp.exercises.ListaParaP2.modulo_a.a1.Validator.*;

public class Principal{
    static void main(String[] args) {

        Produto celular = new Produto("Celular", 5000.00);
        Produto notebook = new Produto("Notebook", 9000.00);
        Produto computador = new Produto("Computador", 6000.00);
        System.out.println(total);

        String email = "contato@empresa.com";

        System.out.println(ehEmail(email));

        String placa = "DIW7598";

        System.out.println(ehPlaca(placa));

        int nota1 = 7;
        int nota2 = 4;
        int nota3 = 6;
        int nota4 = -1;

        System.out.println(classificar(nota1));
        System.out.println(classificar(nota2));
        System.out.println(classificar(nota3));
        System.out.println(classificar(nota4));


    }

}
