package PaqueteListener;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class Microfono extends ResultAdapter {
    static Main m;
    static Recognizer recognizer;
    String gst;
    // el archivo de guardado de comandos debe estar dentro de la libreria
    @Override
    public void resultAccepted(ResultEvent re) {
        try {
            Result res = (Result)(re.getSource());
            ResultToken tokens[] = res.getBestTokens();
            String args[]= new String[1];
            args[0]="";
            for (int i=0; i < tokens.length; i++) {
                gst = tokens[i].getSpokenText();
                args[0]+=gst+" ";
                System.out.println(args[0]+" ");
            }
            if(gst.equals("CERRAR")) {
                // limpia el reconocedor y libera lso recursos utilizados
                recognizer.deallocate();
                System.exit(0);
                System.out.println("Termino Microfono");
            }
            String [] aux = m.capturarComandos(args[0]);
            for (String exe: aux) {
                m.ejecutar(exe);
            }
        } catch(Exception e) {
            System.out.println("Ha ocurrido algo inesperado "
                + e.getMessage());
        }
    }

    public static void main(String args[]) {
        try {
            m = new Main();
            Diccionario.crearDiccionario();
            m.agregarComando("Terminal", new String[]{"cmd", "/c", "start cmd.exe"});
            m.agregarComando("Notas", new String[]{"notepad.exe"});
            
            // la clase Central tiene como metodo interno obtenemos el reconocedor 
            // EngineModeDesc da loas propiedades con las que debe estar el reconoccedor
            // Locale para definir el idioma, region, etc 
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            // asigna los recursos necesarios
            recognizer.allocate();
            // es de tipo JSGF 
            FileReader grammar1 =new FileReader("diccionario.txt");

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);

            recognizer.addResultListener(new Microfono());

            System.out.println("Empieze Dictado");
            recognizer.commitChanges();
            // pide al reconocedor ponerlo estado resumido para poder reconocer las palabras
            recognizer.requestFocus();
            recognizer.resume();
        } catch (Exception e) {
            System.out.println("Exception en " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}
