//package Paquete;  
// clase en duda
import java.io.IOException;
public class Hilo extends Thread{
    
    public void run(String[] comandos) {
        for (String comando: comandos) {
            // este proceso termina de maner aadecuada ?
            try {
                Process p=Runtime.getRuntime().exec(comando);
            } catch (IOException ioe) {}
        }
    }
}
