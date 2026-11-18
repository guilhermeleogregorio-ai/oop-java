package org.guilherme.ifsp.exercises.Prova2.Principal;

import org.guilherme.ifsp.exercises.Prova2.model.*;

public class Principal {
    public static void main(String[] args) {

        Declaracao d1 = new DeclaracaoSimplificada(1,30000.0,0.0);
        DeclaracaoCompleta d2 = new DeclaracaoCompleta(2,27000.0,0.0);
        DespesaSaude s = new DespesaSaude(1,2000.0,"Consulta","1231454544","CRM-1223");
        DespesaEducacao e = new DespesaEducacao(1,500.0,"Consulta","45644564","Crm-544");
        d2.adicionarDespesa(s);
        d2.adicionarDespesa(e);

        System.out.println(d2.valorAPagar());
        System.out.println(d1.valorAPagar());
    }
}
