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

    public void serializar(String path, TOKEN tok) {
        try {
            File f = new File(path);
            if (f.length()==0) {
                openOutput(path);
                output.writeObject(tok);
                closeOutput();
            } else {
                FileOutputStream outputFile = new FileOutputStream(path, true);
                MyObjectOutputStream miOb = new MyObjectOutputStream(outputFile);
                miOb.writeObject(tok);
                miOb.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public ArrayList<TOKEN> read(String path) {
        TOKEN d = null;
        ArrayList<TOKEN> lista = new ArrayList<>();
        try {
            if (output!=null) {
                openInput(path);
                do {
                    d = (TOKEN)input.readObject();
                    lista.add(d);
                }while(d!=null);
            }
        } catch (IOException ioe) {
            
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
        return lista;
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

class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) 
    	throws IOException
    {
        super(out);
    }

    @Override
    public void writeStreamHeader() throws IOException {
        return;
    }
}