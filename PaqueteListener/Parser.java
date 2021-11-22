package PaqueteListener;

import java.util.ArrayList;
import PaqueteListener.Normalizacion.*;
import PaqueteListener.RegularExpresion.*;

class Parser {
    
    public String[] capturar(String oracion, String[] tokens) {
        // con respecto a la particion de la oracion puede ser 
        // por cualquier medio y no podemos optar por decir que debemos separar por 
        // ' ' sino tambien ',' '.' '/' '|' '\'?
        // tendriamos que ver la forma de tomar los tokens
        
        ArrayList<String> tokensEncontrados = new ArrayList<>();
        if (!Normalizador.verificar(oracion)) {
            String textoNormal = Normalizador.normalizar(oracion);
            String[] palabras = textoNormal.split(" ");
            for(String k: palabras) {
                boolean band = false;
                int i = 0;
                while (!band && i<tokens.length) {
                    String id = tokens[i];
                    band = ExpresionRegular.verificarTokens(k,id);
                    if (band) 
                        tokensEncontrados.add(id.toLowerCase());
                    i++;
                }
            }
        }
        String[] aux = new String[tokensEncontrados.size()];
        for (int i = 0; i<tokensEncontrados.size(); i++) {
            aux[i] = tokensEncontrados.get(i);
        }
        return aux;
    }
}
