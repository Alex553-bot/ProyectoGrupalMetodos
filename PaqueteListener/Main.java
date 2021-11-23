package PaqueteListener;

//import PaqueteListener.Serializacion.*;
import PaqueteListener.Normalizacion.*;

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
    
    public static void main(String[] args) {
        Microfono.main(new String[]{""});
        
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
        boolean band = (Normalizador.verificar(id));
        int i=0;
        while(i<comandos.size() && band) {
            band =!(id.equals(comandos.get(i).getIdentificador()));
            if (!band) {
                Hilo hilo = new Hilo();
                hilo.run(comandos.get(i).getComandos());
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
