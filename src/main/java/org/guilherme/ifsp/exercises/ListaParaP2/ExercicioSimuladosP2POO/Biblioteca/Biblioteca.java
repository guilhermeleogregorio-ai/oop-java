package org.guilherme.ifsp.exercises.ListaParaP2.ExercicioSimuladosP2POO.Biblioteca;


import java.util.*;
import java.util.stream.Collectors;

public class
Biblioteca {
    private Map<String, Item> acervo;
    private Map<String, List<Item>> emprestimo;

    public Biblioteca() {
        this.acervo = new LinkedHashMap<>();
        this.emprestimo = new LinkedHashMap<>();
    }


    public void cadastrar(Item item) {
        if (acervo.containsKey(item.getCodigo())) {
            throw new IllegalArgumentException("Erro: Codigo ja cadastrado:" + item.getCodigo());
        }
        acervo.put(item.getCodigo(), item);
    }


    public void emprestar(String usuario, String codigo) {
        List<Item> lista = emprestimo.containsKey(usuario) ? emprestimo.get(usuario) : new ArrayList<>();
        if (acervo.containsKey(codigo) && acervo.get(codigo).isEmprestado()) {
            throw new ItemIndisponivelException("Item ja emprestado: " + codigo);
        }
        if (lista.size() >= 3) {
            throw new IllegalStateException("Regra: Limite de 3 emprestimos atingido por " + usuario);
        }
        if (!acervo.containsKey(codigo)) {
            throw new ItemIndisponivelException("Item inexistente: " + codigo);
        }
        lista.add(acervo.get(codigo));
        acervo.get(codigo).setEmprestado(true);
        emprestimo.put(usuario, lista);

    }

    public double devolver(String usuario, String codigo, int diasComItem) {

        List<Item> lista = emprestimo.containsKey(usuario) ? emprestimo.get(usuario) : new ArrayList<>();
        lista.remove(acervo.get(codigo));
        emprestimo.put(usuario, lista);
        if (acervo.get(codigo).isEmprestado()) {
            acervo.get(codigo).setEmprestado(false);
            return acervo.get(codigo).calcularMulta(diasComItem);
        } else {
            throw new IllegalArgumentException(usuario + "nao possui o item " + codigo);
        }
    }

    public List<Item> emprestadosDe(String usuario) {
        if (!emprestimo.containsKey(usuario)) {
            return new ArrayList<>();
        }
        class ItemComToStringCru extends Item {
            private final Item original;

            public ItemComToStringCru(Item original) {
                // Passa os dados obrigatórios para o construtor da superclasse
                super(original.getCodigo(), original.getTitulo());
                this.original = original;
            }

            @Override
            public int prazoDias() {
                return 0;
            }

            @Override
            public double multaPorDia() {
                return 0;
            }

            @Override
            public String toString() {
                // Pega o nome da classe real original (Livro, Revista, Dvd)
                String tipoReal = original.getClass().getSimpleName();
                return String.format("%s[%s - %s]", tipoReal, getCodigo(), getTitulo());
            }
        }
        return emprestimo.get(usuario).stream()
                .map(itemAntigo -> new ItemComToStringCru(itemAntigo))
                .collect(Collectors.toList()); // Retorna a cópia como List<Item>

    }


    public String relatorio() {
        StringBuilder sb = new StringBuilder();
        for (Item e : acervo.values()) {
            sb.append(e).append("\n");
        }
        return sb.toString();
    }
}

