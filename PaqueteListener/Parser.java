package PaqueteListener;

import java.util.ArrayList;
import PaqueteListener.Normalizacion.*;
import PaqueteListener.RegularExpresion.*;

class Parser {
<<<<<<< HEAD
    public static String[] capturar1(String oracion, String[] tokens) {
=======
    
    public String[] capturar(String oracion, String[] tokens) {
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
        // con respecto a la particion de la oracion puede ser 
        // por cualquier medio y no podemos optar por decir que debemos separar por 
        // ' ' sino tambien ',' '.' '/' '|' '\'?
        // tendriamos que ver la forma de tomar los tokens
        
        ArrayList<String> tokensEncontrados = new ArrayList<>();
        if (!Normalizador.verificar(oracion)) {
            String textoNormal = Normalizador.normalizar(oracion);
            String[] palabras = textoNormal.split(" ");
<<<<<<< HEAD
            for (String k: tokens) {
                for (String palabra: palabras) {
                    if(ExpresionRegular.verificarTokens(palabra, k))
                        tokensEncontrados.add(k);
                }
                /*while (!band && i<tokens.length) {
=======
            for(String k: palabras) {
                boolean band = false;
                int i = 0;
                while (!band && i<tokens.length) {
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
                    String id = tokens[i];
                    band = ExpresionRegular.verificarTokens(k,id);
                    if (band) 
                        tokensEncontrados.add(id.toLowerCase());
                    i++;
<<<<<<< HEAD
                }*/
            }
        }
        String[] aux = new String[tokensEncontrados.size()];
        aux = tokensEncontrados.toArray(aux);
        return aux;
    }
    public String[] capturar(String oracion, String tokens[]) {
        ArrayList<String> encontrados = new ArrayList<>();
        for (String id: tokens) {
            if (ExpresionRegular.verificar(oracion, id))
                encontrados.add(id);
        }
        String[] aux = new String[encontrados.size()];
        return encontrados.toArray(aux);
=======
                }
            }
        }
        String[] aux = new String[tokensEncontrados.size()];
        for (int i = 0; i<tokensEncontrados.size(); i++) {
            aux[i] = tokensEncontrados.get(i);
        }
        return aux;
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
    }
}
