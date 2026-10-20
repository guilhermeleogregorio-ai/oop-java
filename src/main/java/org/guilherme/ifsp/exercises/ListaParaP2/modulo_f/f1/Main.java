package org.guilherme.ifsp.exercises.ListaParaP2.modulo_f.f1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
    }

    static void main(String[] args) {
        List<String > listaNomes = new ArrayList<>();
        listaNomes.add("Guilherme");
        listaNomes.add("Vanessa");
        listaNomes.add("Gabriel");
        listaNomes.add("Caua");
        listaNomes.add( "Lucas");

        listaNomes.remove(0);
        boolean tem = listaNomes.contains("Guilherme");
        int posicao = listaNomes.indexOf("Vanessa");

        for(String e : listaNomes){
            System.out.println(e);
        }
        System.out.println(tem);
        System.out.println(posicao);
        System.out.println(listaNomes.size());
        System.out.println(listaNomes.get(1));

    }
}
