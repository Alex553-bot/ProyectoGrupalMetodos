import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.util.ArrayList;
// esta clase debe identificar todos los comandos de un proyecto por lo que 
// es muy importante 
public class Lector {
    private ArrayList<String>   tokensEncontrados;
    private Parser              parser;
    private ExpresionRegular    verificador;
    private Serializador        serializador;
    public Lector() {
        serializador = new Serializador();
    }

    public static ArrayList<TOKEN> cargarTokens() {
        // en este metodo debemos recuperar los tokens con sus comandos respectivos
        // y devolverlo ya convertidos para poder trabajar con ellos 
        return null;
    }
    public String[] ejecutar(String lengNatural) {
        String tokens[] = parser.capturar(lengNatural, tokensEncontrados);
        String[] res = new String[tokens.length];
        if(tokens.length>0) {
            for (int i = 0; i<tokens.length;i++) {
                String aux=ejecutarCodigoPorComandoUnico(tokens[i]);
                if(aux!="\0")    
                    res[i]=aux;
            }
        }
        return res;
    }

    /*private String ejecutarCodigoPorComandoUnico(String token) {
        String res = capturarCodigo(token);
        String[] aux = res.split("#");
        modificarHilo(aux[0], 5);
        try {
            Process p = 
            Runtime.getRuntime().exec("cd $(CURRENT_DIRECTORY) & javac $(FILE_NAME) & java $(NAME_PART) & pause");
        } catch (java.io.IOException ioe) {
            ioe.printStackTrace();
        }
        Hilo a = new Hilo();
        a.run();
        while(true) {
            if(!a.isAlive()) {
                limpiarHilo();
                break;
            }
        }
        return aux[0];
    }*/

    private String capturarCodigo(String p) {
        String res = "";
        try {
            Reader r = new FileReader(p);
            BufferedReader br = new BufferedReader(r);
            String l = br.readLine();
            while(l!=null) {
                String aux[] = parser.capturar(l);
                if (p.toUpperCase().equals(aux[0])) {
                    while(verificador.verificar(l, "#$")) {
                        l = br.readLine();
                        res += l;
                    }
                }
                while((l!=null) && !verificador.verificar(l, "#$")) {
                    //dentro de este bucle adicional lo que tenemos que realizar es el salto entre lo que es el guardado de un comando de otro
                    l = br.readLine();
                }
            }
        } catch (FileNotFoundException fnfe) {
        } catch (IOException ioe) {}
        return res;
    }
    public void recuperarTokens() {
        try {
            File tokenFile = new File("comandosEjecutables.txt");
            if (tokenFile.length==0) {
                return;
            }
            FileReader fr = new FileReader(tokenFile);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea!=null) {
                
            }
        } catch (IOException ioe) {}
    }


/*
    public Strign[] leerArchivo(File f) throws Exception{
        try {
            if (f.isDirectory()) {
                throw new Exception("es directorio");
            }
            if (f.length==0) {
                throw new Exception("ARCHIVO VACIO");
            }
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line=br.readLine();
            // solo existen comandos dentro de una clase
            boolean band = true;
            while (line!=null && band) {
                band = !(reg.empezoClase(line));
                line = br.readLine();
            }
            // debemos ignorar los comentarios, Anotaciones y el como esta hecho un metodo
            while (line!=null) {
                // aqui debemos especificar
                if (reg.esComentario(line)) {
                    while(line!=null && band) {
                        band = !(reg.terminoComentario(line));
                        line = br.readLine();
                    }
                }
                band = reg.esAnotacion(line);
                if (band && line!=null) {
                    line = br.readLine();
                }
                band = reg.esEspacio(line);
                if (band && line!=null) {
                    while(line!=null && band) {
                        band = reg.esEspacio(line);
                        line = br.readLine();
                    }
                }
                band = reg.esMetodo(line);
                if(band && line!=null) {
                    // la linea que nos interesa es el nombre
                    String[] aux = line.split(" ");
                    for (int i=0; i<aux.length && band; i++) {
                        band = !(reg.esNombre(aux[i]));
                        if(!band) {}
                    }
                }
            }
        } catch (Exception e) {}
    }

    
     * la estructura para cualquier codigo dentro de un archivo tendra que ser tipo: 
     * token
     * #aqui esta el codigo 
     * que debe poder ejecutarse#
     * A la hora de leer > ## modifica la clase Hilo
     */

}
