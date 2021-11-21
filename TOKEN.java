import java.util.ArrayList;
import java.util.HashSet;
import java.io.Serializable;

public class TOKEN implements Serializable {
    // existe un token por defecto que es el de cerrado
    // 'cerrar' termina todos los procesos.
    private String            identificador;
    private HashSet<String>   comandos;
    public void TOKEN(String id, String comando) {
        identificador = Normalizador.normalizar(id);
        comandos = new HashSet<String>();
        comandos.add(comando);
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

    public void setComandos(HashSet<String> comandos) {
        this.comandos = comandos;
    }
    /*
    public void setComando(String comando, int pos) {
        this.comandos.add(pos, comando);
    }*/
    public void setComando(String comando) {
        this.comandos.add(comando);
    }

    public String[] getComandos() {
        return (String[])comandos.toArray();
    }
    public String getIdentificador() {
        return identificador;
    }
    public void setIdentificador(String id) {
        this.identificador = id;
    }
}