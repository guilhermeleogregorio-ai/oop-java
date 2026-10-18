package org.guilherme.ifsp.exercises.collections.Livro;

import java.util.List;

public class Livro {
    String titulo;
    String autor;
    int ano;


    Livro(String autor, String titulo, int ano) {
        this.autor = autor;
        this.titulo = titulo;
        this.ano = ano;
    }

    private void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    private void setAutor(String autor) {
        this.autor = autor;
    }

    private void setAno(int ano) {
        this.ano = ano;
    }

    String getTitulo() {
        return titulo;
    }

    String getAutor() {
        return autor;
    }

    private int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo=" + titulo +
                ", autor='" + autor + '\'' +
                ", ano=" + ano +
                '}';
    }

    static Livro buscarPorTitulo(List<Livro> livros, String titulo){
        for(Livro livro : livros){
                if(livro.getTitulo().equals(titulo)){
                    return livro;
                }
            }
            return null;
        }
    }

