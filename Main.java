import java.io.*;
import java.util.ArrayList;
/***
 * debemos ser capaces de almacenar lo que tiene que ver con
 * en caso del almacenamiento debemos poder guardar comandos?
 * o debemos mapear los comandos 
 * 
 * */
public class Main {
	private File directorio;
	private ArrayList<TOKEN> tokens;
	public Main(String path) throws Exception {
		directorio = new File(path);
		if (!directorio.isDirectory()) {
			directorio = null;
			throw new Exception("el path no es un directorio");
		}
	}

	public void agregarTokens(String TOKEN, String nombreCod) {
		/**
		 * tenemos q tener en cuenta que al crear un token nos 
		 * guardara un archivo de los tokens y adonde lo tiene que dirigir
		 * es decir si se tiene el metodo 'mostrarEjemplo()' y como token "visualizar"
		 * entonces en este caso si el token es lo que buscamos entonces 
		 * buscara el metodo mostrarEjemplo() y le devolvera en donde fue instanciado?
		 * 
		 * */
	}
	public void buscarTokens() {
        try {
            File file = new File("archivo.txt");
            FileReader fr = new FileReader(file);

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } 
    }
    public void cargarLenguaje() {
    	File tFile = new File("Lenguaje.txt");
    	
    }

    public void ejecutar(String id) {
    	return;
    }
}