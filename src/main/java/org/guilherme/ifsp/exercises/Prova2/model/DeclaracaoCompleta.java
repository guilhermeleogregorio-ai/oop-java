package org.guilherme.ifsp.exercises.Prova2.model;

import org.guilherme.ifsp.exercises.Simulado2.game.MarioState;

import java.util.List;
import java.util.Objects;

public class DeclaracaoCompleta extends Declaracao {
    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago, List<Despesa> gastos) {
        super(id, ganhoTributavel, valorJaPago);
        this.gastos = gastos;
    }

    private List<Despesa> gastos;

    @Override
    protected double valorImposto() {
        double ganhoTributavel = getGanhoTributavel() - totalDespesasDedutiveis();
        double valorJaPago = getValorJaPago();
        double valorDoImposto = 0;
        if(ganhoTributavel >= 22847.88 && ganhoTributavel <= 33919.92){
            valorDoImposto = (33919.92 - 22847.88) * 0.075;
        } else if (ganhoTributavel >= 33919.93 && ganhoTributavel <= 45012.72) {
            valorDoImposto = (45012.72 - 33919.93) * 0.15;
        } else if(ganhoTributavel >= 45012.73 && ganhoTributavel <= 55976.16){
            valorDoImposto = (55976.16 - 45012.73) * 0.225;
        } else if (ganhoTributavel > 55976.16) {
            valorDoImposto = 55976.16 * 0.275;
        } else{
            valorDoImposto = 0;
        }
        return valorDoImposto;
    }

    public void adicionarDespesa(Despesa d){
        if(d != null){
            this.gastos.add(d);
        }

    }

    public void removerDespesa(Despesa d){
        if(d != null){
            this.gastos.remove(d);
        }
    }

    private double totalDespesasDedutiveis(){
        double totalSaude = 0.0;
        double totalEducacao = 0.0;
        for(Despesa d : this.gastos) {
            if (d instanceof DespesaSaude) {
                totalSaude += d.getValor();
            } else if (d instanceof DespesaEducacao) {
                totalEducacao += d.getValor();
            }
        }

        double deducaoSaude = Math.min(totalSaude, DespesaSaude.DEDUCAO_MAX);
        double deducaoEducacao = Math.min(totalEducacao, DespesaEducacao.DEDUCAO_MAX);
        return deducaoEducacao + deducaoSaude;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DeclaracaoCompleta that = (DeclaracaoCompleta) o;
        return Objects.equals(gastos, that.gastos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gastos);
    }

    @Override
    public String toString() {
        return "DeclaracaoCompleta{} " + super.toString();
    }
}
