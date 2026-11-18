package org.guilherme.ifsp.exercises.Prova2.model;

abstract public class Declaracao {
    private int id;
    private double ganhoTributavel;
    private double valorJaPago;


    final public double valorAPagar(){
        return  valorImposto() - valorJaPago;
    }

    protected  double valorImposto(){
        return  valorImposto();
    }
}
