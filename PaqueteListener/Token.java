package PaqueteListener;


import java.util.ArrayList;
import java.util.HashSet;
import java.io.Serializable;
import PaqueteListener.Normalizacion.*;

class Token implements Serializable {
    // existe un token por defecto que es el de cerrado
    // 'cerrar' termina todos los procesos.
    private String            identificador;
    private ArrayList<String> ejecutables;
    public Token(String id, String comando) throws Exception {
        setID(id);
        ejecutables = new ArrayList<String>();
        ejecutables.add(comando);
    }
    public Token(String id) throws Exception {
        setID(id);
        ejecutables = new ArrayList<>();
    }
    // los comandos iran de la forma 
    // Process p=Runtime.getRuntime().exec("comando");
    // nota: ejecuta comando a comando en el orden que se haya asignado
    // necesitamos un normalizador para poder transformar los tokens 
    // con respecto a los comandos el uso de una lista es:(Ejemplo)
    // 1 abrir terminal en el directorio actual
    // 2 compilar una clase en java 
    // 3 ejecutar el main de cierto comando y que lo haga en un hilo
    // hasta que lo termine.
    // **** Importante******//
    // debe existir un comando por defecto que es el de cerrar el 'listener'
    // **********************    
    //Observacion: debemos verificar que los comandos estan repetidos?
    public void setComandos(ArrayList<String> comandos) {
        this.ejecutables = comandos;
    }
    public void setComandos(String[] comandos) {
        this.ejecutables = new ArrayList<>();
        for (String comando: comandos) 
            if (Normalizador.verificar(comando))
                this.ejecutables.add(comando);
    }

    public void agregarComando(String comando) {
        if (Normalizador.verificar(comando))
            this.ejecutables.add(comando);
    }

    public String[] getComandos() {
        return (String[])ejecutables.toArray();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setID(String id) throws Exception {
        if (Normalizador.verificar(id))
            throw new Exception("nombre invalido");
        identificador = Normalizador.normalizar(id);
    }
}