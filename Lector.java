import java.io.BufferedReader;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Lector {
    private Parser parser;
    ExpresionRegular verificador;
    public String[] ejecutar(String lengNatural) {
        String tokens[] = parser.capturar(lengNatural);
        String[] res = new String[tokens.length];
        if(tokens.length>0) {
            for (int i = 0; i<tokens.length;i++) {
                String aux=ejecutarCodigoPorComandoUnico(tokens[i]);
                if(aux!="\0")    res[i]=aux;
            }
        }
        return res;
    }

    private String ejecutarCodigoPorComandoUnico(String token) {
        String res = capturarCodigo(token);
        String[] aux = res.split("#");
        modificarHilo(aux[0], 5);
        try {
            Process p = Runtime.getRuntime().exec("cd $(CURRENT_DIRECTORY) & javac $(FILE_NAME) & java $(NAME_PART) & pause");
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
    }

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

    private void modificarHilo(String cod, int a) {
        FileWriter file;
        PrintWriter writer=null;
        try {
            file = new FileWriter("Hilo.java");
            writer = new PrintWriter(file);
            writer.flush();
            String split[] = leerHilo().split("\n");
            split[a] = cod;
            for(int i=0; i<split.length; i++){
                writer.write(split[i]);
                writer.println();
            }
            writer.close();
        } catch (IOException e) {
        } finally {
            try {
                writer.close();
            } catch(Exception e) {}
        } 
    }

    public String leerHilo() {
        String cadena = "";
        FileReader entrada = null;
        try {
            entrada = new FileReader("Hilo.java");
            int c;
            while((c = entrada.read()) != -1){
                cadena += (char)c;
            }
        } catch (Exception e) {}
        return cadena;

    }

    private void limpiarHilo() {
        FileWriter file;
        PrintWriter writer=null;
        try {
            file = new FileWriter("Hilo.java", false);
            writer = new PrintWriter(file);
            writer.flush();
            writer.write("public class Hilo extends Thread{");
            writer.write("@Override");
            writer.write("public void run() {");
            writer.write("");
            writer.write("}");
            writer.write("}");
            writer.close();
        } catch (IOException e) {
        } finally {
            try {
                writer.close();
            } catch(Exception e) {}
        } 
    }

    /**
     * la estructura para cualquier codigo dentro de un archivo tendra que ser tipo: 
     * token
     * #aqui esta el codigo 
     * que debe poder ejecutarse#
     * A la hora de leer > ## modifica la clase Hilo
     */
}
