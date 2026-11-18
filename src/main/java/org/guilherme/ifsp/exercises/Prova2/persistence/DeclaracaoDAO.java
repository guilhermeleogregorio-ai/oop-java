package org.guilherme.ifsp.exercises.Prova2.persistence;

import org.guilherme.ifsp.exercises.Prova2.model.Declaracao;

import java.util.Optional;

public interface DeclaracaoDAO {
    void salvar(Declaracao declaracao);
    void atualizar(Declaracao declaracao);
    void remover(Declaracao declaracao);
    Optional<Declaracao> buscarPorId(int id);

}
