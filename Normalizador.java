import java.text.Normalizer;

public class Normalizador {
	// solo se normaliza los identificadores, no los comandos a realizar
	// los identificadores pueden contener numeros?
	public static String normalizar(String cad) {
		cad = Normalizer.normalize(cad, Normalizer.Form.NFD);
        cad = cad.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return cad.toUpperCase();
	}

	public static boolean verificar(String cad) {
		return ((cad==null) || (cad.isEmpty()));
	} 
}