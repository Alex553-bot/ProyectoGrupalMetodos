package PaqueteListener;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

/**
 * tenemos que tener en cuenta los siguienets aspectos:
 * 1. dado un tipo de lista podamos almacenarla
 * 2. un archivo guardado debe poder abrise y compilar las clases 
 * PARA EL USO DE LA SERIALIZACION LA CLASE SERIALIZABLE DEBE SER DE TIPO SERIALIZABLE.
 * OTRO POSIBLE CASO ES CREAR UN CLASE DATOS DE TIPO CONTENEDORA O ENVOLTORIA QUE EXTIENDA LA CLASE SERIALIZABLE
 * Todos los atributos deben ser serializables!! 
 * */
// .ser .bin .txt?
//transforma a un flujo de bytes
public class Serializador {
    private FileOutputStream  outputFile;
    private FileInputStream  inputFile;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    public void serializar(String path, ArrayList<Token> o) {
        try {
            File f = new File(path);
            openOutput(path);
            output.writeObject(o);
            closeOutput();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Token> recuperarArray(String path) {
        try {
            openInput(path);
            ArrayList<Token> lista = (ArrayList<Token>)input.readObject();
            return lista;
        } catch (IOException ioe) {
        } catch (ClassNotFoundException cnfe){
        }
        return null;
    }

    private void openOutput(String path) throws IOException {
        outputFile = new FileOutputStream(path,false);
        output = new ObjectOutputStream(outputFile);
    }

    private void openInput(String path) throws IOException {
        inputFile = new FileInputStream(path);
        input = new ObjectInputStream(inputFile);
    }

    private void closeOutput() throws IOException {
        if (output!=null) output.close();
    }

    private void closeInput() throws IOException {
        if (input!=null) input.close();
    }

}

