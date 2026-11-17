package org.guilherme.ifsp.exercises.ListaParaP2.modulo_a.a1;

public class Validator {
    private Validator() {
    }

    static boolean ehEmail(String texto){
        if(texto == null || texto.equals("")) {
            return false;
        }

        int index = texto.indexOf("@");
        if(index < 1) {return false;
        }
        else {
            for (int i = index + 1; i < texto.length(); i++) {
                char caracterAtual = texto.charAt(i);
                if (!Character.isLetterOrDigit(caracterAtual) && caracterAtual != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean ehPlaca(String texto){
        if(texto.length() != 7){
            return false;
        }
        for(int i = 0 ; i < texto.length() ; i++){
            char caracterAtual = texto.charAt(i);
            if(!Character.isLetter(caracterAtual) && i < 3){
                return false;
            }
            if(!Character.isLetterOrDigit(caracterAtual) && i > 2){
                return false;
            }
        }
        return true;
    }
    static String classificar(int nota){
        if(nota < 0 || nota > 10){
            throw new IllegalArgumentException("Nota com valor invalido");
        }
        if(nota >= 6){
            return "Aprovado";
        } else {return "Reprovado";}
    }
}
