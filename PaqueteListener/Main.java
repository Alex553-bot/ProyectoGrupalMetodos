package PaqueteListener;

//import PaqueteListener.Serializacion.*;
import PaqueteListener.Normalizacion.*;
<<<<<<< HEAD
import java.io.IOException;
=======
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702

import java.util.ArrayList;

public class Main {
    private ArrayList<Token> comandos;
    public Main(String path) {
        cargarTokens(path);
    }
    // si es la primera vez usa este constructor
    public Main() {
        comandos = new ArrayList<>();
    }
    
<<<<<<< HEAD
    public static void main(String[] args){
        try {
            Process p = Runtime.getRuntime().exec("notepad.exe");
        } catch (IOException ioe) {}
    }
    
    public static void main1() throws Exception{
        Token t = new Token("a", "notepad.exe");
        Hilo h = new Hilo();
        h.run(t.getComandos());
=======
    public static void main(String[] args) {
        Microfono.main(new String[]{""});
        
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
    }
    
    public String[] capturarComandos(String cadena) {
        Parser parser = new Parser();
        String[] lista = new String[comandos.size()];
        for (int i=0; i<comandos.size();i++) {
            lista[i] = comandos.get(i).getIdentificador();
        }
        return parser.capturar(cadena,lista);
    }
    // por el momento nuestro guardado no admite que directamente se modifiquen tokens junto a su proceso
    public void agregarComando(String id, String[] ejecuciones) {
        try {
            Token t = new Token(id);
            t.setEjecutables(ejecuciones);
            guardarDiccionario(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarTokens(String path) {
        Serializador ser = new Serializador();
        ArrayList<Token> aux = ser.recuperarArray(path);
        comandos = aux;
    }
    
    public void ejecutar(String id) {
<<<<<<< HEAD
        boolean band = (!Normalizador.verificar(id));
        int i=0;
        while(i<comandos.size() && band) {
            band =!(id.equalsIgnoreCase(comandos.get(i).getIdentificador()));
            if (!band) {
                Hilo hilo = new Hilo();
                hilo.run(comandos.get(i).getComandos());
                /*
                try {
                    Process p = Runtime.getRuntime().exec(comandos.get(i).getComandos());
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }*/
=======
        boolean band = (Normalizador.verificar(id));
        int i=0;
        while(i<comandos.size() && band) {
            band =!(id.equals(comandos.get(i).getIdentificador()));
            if (!band) {
                Hilo hilo = new Hilo();
                hilo.run(comandos.get(i).getComandos());
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
            }
            i++;
        }
    }

    private void guardarDiccionario(Token tok) {
        comandos.add(tok);
        // a la hora de guardar el token debemos tener en cuenta que se debe crear su identificador en 
        Diccionario.agregarIdentificador(tok.getIdentificador(), comandos.size());
    }
    
    public void guardarTokens(String path) {
        Serializador ser = new Serializador();
        ser.serializar(path, comandos);
            //System.out.println(t.toString());
    }
}
