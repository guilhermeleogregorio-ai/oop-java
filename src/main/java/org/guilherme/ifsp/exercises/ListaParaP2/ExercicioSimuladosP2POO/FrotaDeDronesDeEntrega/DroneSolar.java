package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.FrotaDeDronesDeEntrega;

final class DroneSolar extends DroneLeve {
    public DroneSolar(String id, int bateria) {
        super(id, bateria);
    }

    @Override
    protected double custoPorKm(){
        return 0.3;
    }

    public void entregar(Pedido pedido){
        super.entregar(pedido); bateria = Math.min(100, bateria + 5);
    }
}
