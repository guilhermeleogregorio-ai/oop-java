package org.guilherme.ifsp.exercises.ListaParaP2.modulo_f.f2;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static void main(String[] args) {
        Set<String> listaNomes = new LinkedHashSet<>();
        String[] nomes =  {"Guilherme","Guilherme","Vanessa","Vanessa","Va","Va","Pedro","Pedro"};
        listaNomes.addAll(List.of(nomes));

        for(String e : listaNomes){
            System.out.println(e);
        }
        System.out.println(nomes.length);
        System.out.println(listaNomes.size());
    }
}
