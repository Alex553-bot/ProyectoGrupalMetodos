package PaqueteListener;

import javax.speech.*;
import javax.speech.recognition.*;
import java.io.FileReader;
import java.util.Locale;

public class Microfono extends ResultAdapter {
    static Main m;
    static Recognizer recognizer;
    String gst;
    public static void crear(Main main) {
        m = main;
    }
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
            if(gst.equals("Cerrar")) {
                recognizer.deallocate();
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
            recognizer = Central.createRecognizer(new EngineModeDesc(Locale.ROOT));
            recognizer.allocate();

            FileReader grammar1 =new FileReader("diccionario.txt");

            RuleGrammar rg = recognizer.loadJSGF(grammar1);
            rg.setEnabled(true);

            recognizer.addResultListener(new Microfono());

            System.out.println("Empieze Dictado");
            recognizer.commitChanges();

            recognizer.requestFocus();
            recognizer.resume();
        } catch (Exception e) {
            System.out.println("Exception en " + e.toString());
            e.printStackTrace();
            System.exit(0);
        }
    }
}