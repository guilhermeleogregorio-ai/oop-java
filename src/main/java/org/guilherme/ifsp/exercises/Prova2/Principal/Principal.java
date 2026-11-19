package org.guilherme.ifsp.exercises.Prova2.Principal;

import org.guilherme.ifsp.exercises.Prova2.exception.EntityAlreadyExists;
import org.guilherme.ifsp.exercises.Prova2.model.*;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDAO;
import org.guilherme.ifsp.exercises.Prova2.persistence.DeclaracaoDaoImpl;
import org.guilherme.ifsp.exercises.Prova2.service.*;

import java.util.NoSuchElementException;

public class Principal {
    public static void main(String[] args) {
        // 1. Instanciando o DAO e injetando nos serviços
        DeclaracaoDAO dao = new DeclaracaoDaoImpl();
        NovaSimulacaoService novaSimulacaoService = new NovaSimulacaoService(dao);
        AdicionarDespesaService adicionarDespesaService = new AdicionarDespesaService(dao);
        ExcluirSimulacaoService excluirSimulacaoService = new ExcluirSimulacaoService(dao);
        RelatorioSimulacaoService relatorioSimulacaoService = new RelatorioSimulacaoService(dao);

        System.out.println("=== TESTE 1: Exceções antes de iniciar simulação ===");
        try {
            adicionarDespesaService.adicionar(1, 500.0, "Consulta", "11.111.111/0001-11", "CRM-1234", TipoDespesa.valueOf(String.valueOf(TipoDespesa.SAUDE)));
        } catch (IllegalStateException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        try {
            excluirSimulacaoService.excluir();
        } catch (NoSuchElementException e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n=== TESTE 2: Iniciando nova simulação ===");
        // Exemplo: Ganho tributável de R$ 60.000,00 e R$ 2.000,00 já pagos na fonte
        novaSimulacaoService.iniciar(60000.0, 2000.0);
        System.out.println(relatorioSimulacaoService.criarRelatorio());

        System.out.println("=== TESTE 3: Tentando iniciar simulação duplicada ===");
        try {
            novaSimulacaoService.iniciar(50000.0, 1000.0);
        } catch (EntityAlreadyExists e) {
            System.out.println("Exceção capturada com sucesso: " + e.getMessage());
        }

        System.out.println("\n=== TESTE 4: Adicionando despesas (dentro do limite) ===");
        adicionarDespesaService.adicionar(1, 800.0, "Consulta Cardiologista", "12.345.678/0001-99", "CRM-9876", TipoDespesa.valueOf(String.valueOf(TipoDespesa.SAUDE)));
        adicionarDespesaService.adicionar(2, 1200.0, "Mensalidade Faculdade", "98.765.432/0001-11", "IFSP", TipoDespesa.valueOf(String.valueOf(TipoDespesa.EDUCACAO)));
        System.out.println(relatorioSimulacaoService.criarRelatorio());

        System.out.println("=== TESTE 5: Adicionando mais despesas (ultrapassando o teto de R$ 1500 saúde e R$ 2000 educação) ===");
        adicionarDespesaService.adicionar(3, 1000.0, "Exame Laboratorial", "22.222.222/0001-22", "CRM-5555", TipoDespesa.valueOf(String.valueOf(TipoDespesa.SAUDE)));
        adicionarDespesaService.adicionar(4, 1500.0, "Curso de Idiomas", "33.333.333/0001-33", "Escola de Línguas", TipoDespesa.valueOf(String.valueOf(TipoDespesa.EDUCACAO)));
        System.out.println(relatorioSimulacaoService.criarRelatorio());

        System.out.println("=== TESTE 6: Excluindo simulação e verificando ===");
        excluirSimulacaoService.excluir();
        System.out.println("Simulação excluída com sucesso!");

        try {
            System.out.println(relatorioSimulacaoService.criarRelatorio());
        } catch (NoSuchElementException e) {
            System.out.println("Exceção capturada após exclusão: " + e.getMessage());
        }
    }

}
