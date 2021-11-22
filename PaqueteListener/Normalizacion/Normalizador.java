package PaqueteListener.Normalizacion;


//package Paquete.Normalizacion; 

import java.text.Normalizer;

public class Normalizador {
    // solo se normaliza los identificadores, no los comandos a realizar
    // los identificadores pueden contener numeros?
    public static String normalizar(String cad) {
        String text = cad.replaceAll("\\s+", " ").trim();
        //text = text.replaceAll("[,\\{\\}\\[\\]\\'/]",",");
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return text.toUpperCase();
    }

    public static boolean verificar(String cad) {
        return ((cad==null) || (cad.isEmpty()));
    } 
    
}