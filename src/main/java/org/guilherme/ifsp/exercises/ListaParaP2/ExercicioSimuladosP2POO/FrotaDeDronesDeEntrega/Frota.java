package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.FrotaDeDronesDeEntrega;


import java.util.*;

public class Frota {
    private final Map<String,Drone> drones = new TreeMap<>();
    private final List<Pedido> pedidos = new ArrayList<>();

    public Frota() {
    }

    public void adicionar(Drone drone){
            if(drones.containsKey(drone.getId())){
                throw new IllegalArgumentException ("Drone repetido: " + drone.getId());
            } else{
                drones.put(drone.getId(),drone);
            }
    }

    public void solicitar(Pedido pedido){
        pedidos.add(pedido);
    }

    public void recarregar(String id){
        Drone drone = drones.get(id);
        if(drone != null){
            drone.setBateria(100);
        }
    }
    public static <T extends Entregador> T maisBarato(Collection<T> candidatos , Pedido pedido){
        T melhor = null;
        double menorCusto = Double.MAX_VALUE;
        for(T atual : candidatos) {
            double custoAtual = atual.custo(pedido);
            if (melhor == null || custoAtual < menorCusto
                    || (custoAtual == menorCusto && atual.id().compareTo(melhor.id()) < 0)) {
                melhor = atual;
                menorCusto = custoAtual;
            }
        }
        return melhor;
    }

    public Drone atribuir(Pedido pedido) {
        List<Drone> lista = new ArrayList<>();
        for (Drone d : drones.values()) {
            if (d.podeEntregar(pedido)) {
                lista.add(d);
            }
        }
        Drone escolhido = maisBarato(lista, pedido);
        if (escolhido == null) {
            throw new SemDroneDisponivelExcpetion("nenhum drone pode atender " + pedido.getId());
        }
        escolhido.entregar(pedido);
        return escolhido;
    }

    public String processarPendentes() {
        Iterator<Pedido> listaPendente = pedidos.iterator();
        StringBuilder sb = new StringBuilder();

        while (listaPendente.hasNext()) {
            Pedido atual = listaPendente.next();
            try {
                Drone droneAtribuido = this.atribuir(atual);
                listaPendente.remove();
                sb.append(String.format("%s -> %s (custo %.2f)\n", atual, droneAtribuido.getId(), droneAtribuido.custo(atual)));
            } catch (SemDroneDisponivelExcpetion e) {
                sb.append(String.format("%s -> PENDENTE (%s)\n", atual, e.getMessage()));
            }
        }
        return sb.toString();
    }

    public List<Drone> dronesPorBateria(){
        List<Drone>  copia = new ArrayList<>(drones.values());
        Collections.sort(copia);
        return copia;
    }

    public int totalPendentes(){
        return pedidos.size();
    }
}
