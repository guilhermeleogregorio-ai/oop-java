package org.guilherme.ifsp.exercises.collections.treino;

import java.util.*;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String>  lista = new ArrayList<>();

        System.out.println("Digite algo ou 'sair' para sair");

        String entradaUsuario = scanner.nextLine();

        while (!entradaUsuario.equalsIgnoreCase("sair")){
            lista.add(entradaUsuario);
            System.out.println("Digite algo ou 'sair' para sair");
            entradaUsuario = scanner.nextLine();
        }
        lista.sort(String::compareTo);
        System.out.println(lista);

        Set<String> setLista = new LinkedHashSet<>();
        setLista.addAll(lista);
        System.out.println(setLista);

        Map<String,Integer> mapList = new HashMap();
        for(String nomes: lista){
            mapList.put(nomes,mapList.getOrDefault(nomes,0)+1);
        }

        for(Map.Entry<String,Integer> entrada : mapList.entrySet()){
            String nome = entrada.getKey();
            int quantidade = entrada.getValue();

            System.out.println(nome +": " +quantidade );
        }
        scanner.close();
    }
}
