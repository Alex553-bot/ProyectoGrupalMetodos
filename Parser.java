import java.io.File;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Parser {
    ExpresionRegular reg;
    public String[] capturar(String oracion) {
        String[] palabras = oracion.split(" ");
        String res[]=new String[TOKEN.lista.size()];
        int j =0;
        for(int i = 0; i<palabras.length;i++) {
            for(String s: TOKEN.lista) {
                if(reg.verificarTokens(palabras[i],s)) {
                    res[j] = s;
                }
            }
        }
        return null;
    }

}
