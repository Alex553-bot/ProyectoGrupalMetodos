package PaqueteListener;

import PaqueteListener.Serializacion.*;
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
    public void agregarComando(String id, String[] comando) {
        try {
            Token t = new Token(id);
            for (String c: comando) {
                t.agregarComando(c);
            }
            guardarToken(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void cargarTokens(String path) {
        Serializador<Token> ser = new Serializador();
        comandos = ser.recuperar(path+"TOKENS.txt");
    }
    
    private void ejecutar(String id) {
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

    private void guardarToken(Token tok) {
        comandos.add(tok);
        // a la hora de guardar el token debemos tener en cuenta que se debe crear su identificador en 
        Diccionario.agregarIdentificador(tok.getIdentificador(), comandos.size()+1);
    }
    
    public void guardarTokens(String path) {
        Serializador<Token> ser = new Serializador();
        for (Token t: comandos)
            ser.serializar(path+"TOKENS.txt", t);
    }
}
