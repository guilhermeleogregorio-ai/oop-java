package org.guilherme.ifsp.exercises.Prova2.model;

import org.guilherme.ifsp.exercises.Simulado2.game.MarioState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DeclaracaoCompleta extends Declaracao {
    public DeclaracaoCompleta(int id, double ganhoTributavel, double valorJaPago, List<Despesa> gastos) {
        super(id, ganhoTributavel, valorJaPago);
        this.gastos = new ArrayList<>();
    }

    private final List<Despesa> gastos;

        @Override
        protected double valorImposto() {
            double baseCalculo = getGanhoTributavel() - totalDespesasDedutiveis();
            double imposto = 0.0;

            if (baseCalculo > 55976.16) {
                imposto += (baseCalculo - 55976.16) * 0.275;
                baseCalculo = 55976.16;
            }
            if (baseCalculo > 45012.72) {
                imposto += (baseCalculo - 45012.72) * 0.225;
                baseCalculo = 45012.72;
            }
            if (baseCalculo > 33919.92) {
                imposto += (baseCalculo - 33919.92) * 0.15;
                baseCalculo = 33919.92;
            }
            if (baseCalculo > 22847.88) {
                imposto += (baseCalculo - 22847.88) * 0.075;
            }

            return imposto;
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
