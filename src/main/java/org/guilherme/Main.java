package org.guilherme;
/*1.	Crie a classe Livro (titulo, autor, ano) com construtor, getters e toString. Gere tudo com Alt+Insert.
2.	Em main, crie uma List<Livro> com 5 livros, 2 do mesmo autor, e imprima todos com for-each.
3.	Monte um Map<String, Integer> com a quantidade de livros por autor e imprima.
4.	Use um Set para mostrar quantos autores diferentes existem.
5.	Escreva static Livro buscarPorTitulo(List<Livro> livros, String titulo), que devolve o livro ou null. Aqui o for-each com equals é o caminho certo.
6.	Crie um Map<String, Livro> porTitulo. Consulte um título com containsKey e get, e remova um livro.
*/

import java.util.*;

import static org.guilherme.Livro.buscarPorTitulo;


public class Main {
    public static void main(String[] args) {

        //2
        List<Livro> estante = new ArrayList<>();


        estante.add(new Livro("Pedro", "As cronicas" ,2000));
        estante.add(new Livro("samira", "As cronicas de dada" ,2220));
        estante.add(new Livro("otavio", "lord" ,1999));
        estante.add(new Livro("Pedro", "As cronicas de monte carlo" ,1900));
        estante.add(new Livro("Paker", "As aventuras de pi" ,1998));


        for(Livro livro :estante ){
            System.out.println(livro.toString());
        }


        //3
        Map<String,Integer> livros = new HashMap<>();

        for(Livro livro: estante){
            String autor = livro.getAutor();
          livros.put(autor, livros.getOrDefault(autor,0) + 1);
        }

        for(Map.Entry<String,Integer> e : livros.entrySet()){
            System.out.println(e.getKey() + ": "+ e.getValue());
        }


        //4
        Set<String> unicos = new HashSet<>();
        for(Livro autores: estante){
            String autor = autores.getAutor();
            unicos.add(autor);
        }
        System.out.println(unicos.size());

    //5
        System.out.println(buscarPorTitulo(estante,"As cronicas")); // não consegui fazer funcionar

        Map<String,Livro> porTitulo = new HashMap<>();
        for(Livro livro : estante){
            porTitulo.put(livro.getTitulo(),livro);
        if(porTitulo.containsKey("As cronicas")){
            System.out.println(porTitulo.get("As cronicas"));
        }

        }
        porTitulo.remove("As cronicas");

        System.out.println(porTitulo);
    }
}






