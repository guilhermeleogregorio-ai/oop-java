package org.guilherme.ifsp.exercises.Prova2.persistence;

import org.guilherme.ifsp.exercises.Prova2.model.Declaracao;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class DeclaracaoDaoImpl implements DeclaracaoDAO{
    private final Map<Integer , Declaracao> db = new LinkedHashMap<>();


    @Override
    public void salvar(Declaracao declaracao) {
        db.put(declaracao.getId(), declaracao);
    }

    @Override
    public void atualizar(Declaracao declaracao) {
        db.replace(declaracao.getId(), declaracao);
    }

    @Override
    public void remover(Declaracao declaracao) {
        db.remove(declaracao.getId());
    }

    @Override
    public Optional<Declaracao> buscarPorId(int id){
        return Optional.ofNullable(db.get(id));
    }
}
