package org.guilherme.ifsp.exercises.TreinoPOO.RelationshipBetweenClasses;

import java.util.Random;

import static java.util.Collections.sort;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;



    public void marcarLuta(){

    }

    public void lutar(){
        Random random = new Random();
        if(aprovada){
            desafiado.apresentar();
            int vencedor = random.nextInt(3);
            switch (vencedor) {
                case 0:
                    System.out.println("Empatou!");
                    desafiado.empatarLuta();
                    desafiante.empatarLuta();
                case 1:
                    System.out.println("Desafiante %s ganhou!" + desafiante.getNome());
                    desafiante.ganharLuta();
                    desafiado.perdeLuta();
                case 2:
                    System.out.println("Desafiado %s ganhou!" + desafiante.getNome());
                    desafiado.ganharLuta();
                    desafiante.perdeLuta();
            }
        }else{
            System.out.println("Luta não pode acontecer");
        }
    }
}
