
import java.util.HashMap;

import java.util.ArrayList;

public class Parser {
    
    public String[] capturar(String oracion, String[] tokens) {
        // con respecto a la particion de la oracion puede ser 
        // por cualquier medio y no podemos optar por decir que debemos separar por 
        // ' ' sino tambien ',' '.' '/' '|' '\'?
        /*ArrayList<String> tokensEncontrados = new ArrayList<>();
        if (!Normalizador.isEmpty(oracion)) {
            String[] palabras = oracion.split();
            for(String k: palabras) {
                boolean band = false;
                while (!band) {
                    band = ExpresionRegular.verificarTokens(k,id);
                    if (band) 
                        tokensEncontrados.add(k);
                }
            }
            return tokensEncontrados.toArray();
        }*/
        //return tokensEncontrados.toArray();
        return null;
    }
}


/**
 * SEGUNDO PROYECTO (Grupo):  (Paquete .jar)
    Grupos de 2 o 3 componentes
    Realizar un paquete que permita manejar:
    Utilizar comandos de VOZ para mapear acciones de cualquier aplicación.
        - Mapear un comando de voz con una instrucción o conjunto de instrucciones
          de su aplicación
        - Dado un texto (como cadena, en lenguaje natural), debe extraer comandos
          o instrucciones de la aplicación.
        Si tenemos un proyecto proyecto, este debe tener n comandos y nosotros debemos 
        reconocer los comandos y devolverlos de la cadena dada.

    el usuario debe poder crear comando ?
    o debe poder crear comandos de voz!!
*/


/* para el guardado de estos comandos tenemos que tener en cuenta 
    que ses tiene una gramatica y para el almacenmaiento tenemos (comando de voz)
   pero en caso en el que tengamos la creacion de estos comandos entonces debemos
   tener un archivo que almacene los codigos?
   si fuera el caso entonces tenemos que poder realizar los comandos?
*/