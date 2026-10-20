package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.Biblioteca;

public abstract class Item implements Emprestavel {
    private String codigo;
    private String titulo;
    private boolean emprestado;

    public Item(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;

    }

    public double calcularMulta(int diasComItem){
         if (diasComItem > prazoDias()){
             return  (diasComItem - prazoDias()) * multaPorDia();
         }  else {
           return 0;
         }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    @Override
    public String toString() {
        return String.format("%-6s | %-8s | %-22s | %s%n ", codigo,getClass().getSimpleName(),titulo,isEmprestado() ? "EMPRESTADO" : "DISPONIVEL" );
    }
}
