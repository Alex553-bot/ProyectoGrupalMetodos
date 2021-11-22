package PaqueteListener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import PaqueteListener.RegularExpresion.*;

class Diccionario {
    private static File diccionario;

    public static void agregarIdentificador(String pal, int i) {
        diccionario = new File("diccionario.txt");
        // tenemos que agregar de manera correcta el agregado de nuevos identificadores.

        /***
         * dentro del archivo tendremos que saber si es que este si esta vacia 
         * si fuera el caso entonces empezamos creandolo 
         * con el formato de reconocimiento por cmop
         * 
         */
        try {
            FileReader reader = new FileReader(diccionario);
            BufferedReader br = new BufferedReader(reader);
            String aux = "";
            String linea=br.readLine();
            while (linea!=null) {
                if (similar(linea.trim(), "public")) {
                    while (!similar(linea,";")) {
                        aux += linea+"\n";
                        linea = br.readLine();
                    }
                    aux+="[<dato"+i+">]\n";
                    aux+=";\n";
                    linea = br.readLine();
                }
                aux += linea+"\n";
                linea=br.readLine();
            }
            aux += "<dato"+i+">="+pal+";";
            FileWriter fr = new FileWriter(diccionario, false);
            BufferedWriter bw = new BufferedWriter(fr);
            bw.write(aux);
            bw.close();
            fr.close();
        } catch (IOException ioe) {}
    }

    public static void crearDiccionario() {
        /**
         * Formato:
         * #JSGF V1.0;
        grammar sentence;

        public <sentence> =
        [<dato0>]

        <dato0>=Metodologia de la Investigacion Cientifica;
         */
        try {
            diccionario = new File("diccionario.txt");
            String aux = "#JSGF V1.0;\ngrammar sentence;\n\n";
            aux += "public <sentence> = \n[<dato0>]\n;\n";
            aux += "<dato0> = Cerrar;";
            FileWriter fr = new FileWriter(diccionario, false);
            fr.write(aux);
            fr.close();
        } catch (IOException ioe) {}
    }
    private static boolean similar(String s1, String s2) {
        s1 = s1.trim();
        String [] p1 = s1.split(" ");
        boolean res = true;
        //System.out.println(p1[0]);
        return (p1[0].equals(s2));
    }
}