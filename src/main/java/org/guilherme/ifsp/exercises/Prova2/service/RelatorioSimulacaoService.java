package org.guilherme.ifsp.exercises.Prova2.service;

import org.guilherme.ifsp.exercises.Prova2.model.*;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class RelatorioSimulacaoService {
    private final DeclaracaoDAO dao;

    public RelatorioSimulacaoService(DeclaracaoDAO dao) {
        this.dao = dao;
    }

        public String criarRelatorio() {
            // Considerando ID 1 = Simplificada e ID 2 = Completa
            DeclaracaoSimplificada simplificada = (DeclaracaoSimplificada) dao.buscarPorId(1)
                    .orElseThrow(() -> new NoSuchElementException("Declaração simplificada não encontrada."));

            DeclaracaoCompleta completa = (DeclaracaoCompleta) dao.buscarPorId(2)
                    .orElseThrow(() -> new NoSuchElementException("Declaração completa não encontrada."));

            StringBuilder relatorio = new StringBuilder();
            relatorio.append("=== RELATÓRIO DE SIMULAÇÃO IRPF ===\n\n");

            // Dados da Declaração Simplificada
            relatorio.append("--- Declaração Simplificada ---\n");
            relatorio.append(simplificada.toString()).append("\n");
            relatorio.append(String.format("Imposto a pagar: R$ %.2f\n\n", simplificada.valorAPagar()));

            // Dados da Declaração Completa
            relatorio.append("--- Declaração Completa ---\n");
            relatorio.append(completa.toString()).append("\n");
            relatorio.append(String.format("Imposto a pagar: R$ %.2f\n\n", completa.valorAPagar()));

            // Agrupamento das despesas por tipo
            relatorio.append("Despesas Dedutíveis Agrupadas:\n");
            Map<String, List<Despesa>> despesasPorTipo = completa.getGastos().stream()
                    .collect(Collectors.groupingBy(d -> d instanceof DespesaSaude ? "Saúde" : "Educação"));

            // Saúde
            List<Despesa> saude = despesasPorTipo.getOrDefault("Saúde", List.of());
            double totalSaude = saude.stream().mapToDouble(Despesa::getValor).sum();
            double deduzidoSaude = Math.min(totalSaude, DespesaSaude.DEDUCAO_MAX);

            relatorio.append(String.format("* Saúde (Total gasto: R$ %.2f | Efetivamente deduzido: R$ %.2f)\n", totalSaude, deduzidoSaude));
            saude.forEach(d -> relatorio.append("   - ").append(d.toString()).append("\n"));

            // Educação
            List<Despesa> educacao = despesasPorTipo.getOrDefault("Educação", List.of());
            double totalEducacao = educacao.stream().mapToDouble(Despesa::getValor).sum();
            double deduzidoEducacao = Math.min(totalEducacao, DespesaEducacao.DEDUCAO_MAX);

            relatorio.append(String.format("* Educação (Total gasto: R$ %.2f | Efetivamente deduzido: R$ %.2f)\n", totalEducacao, deduzidoEducacao));
            educacao.forEach(d -> relatorio.append("   - ").append(d.toString()).append("\n"));

            return relatorio.toString();
        }
    }

