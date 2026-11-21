package org.guilherme.ifsp.exercises.TreinoPOO.RelationshipBetweenClasses;

public class Main {
    public static void main(String[] args) {
        Lutador[] L = new Lutador [6];
        L[0] = new Lutador("Pretty", "França",31,1.75,68.9,11,3,1);
        L[1] = new Lutador("Put","Brasil",29,1.69,57.8,14,2,3);
        L[2] = new Lutador("Snap","Eua",35,1.65,80.9,12,2,1);
        L[3] = new Lutador("Code","Austria",28,1.93,82.6,13,0,2);
        L[4] = new Lutador("Pedro","Brasil",38,1.95,98.2,10,5,2);
        L[5] = new Lutador("Pitte","Eua",25,1.78,78.5,13,5,1);

        Luta UEC01 = new Luta();
        UEC01.marcarLuta(L[0],L[1]);
        UEC01.lutar();
        Luta EUC02 = new Luta();
        EUC02.marcarLuta(L[3],L[5]);
        EUC02.lutar();


    }
}
