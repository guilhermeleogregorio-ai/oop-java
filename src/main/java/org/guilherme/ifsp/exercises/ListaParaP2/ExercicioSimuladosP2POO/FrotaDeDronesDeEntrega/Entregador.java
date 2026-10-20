package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.FrotaDeDronesDeEntrega;

public interface Entregador {
    public String id();
    public boolean podeEntregar(Pedido pedido);
    public double custo(Pedido pedido);
}
