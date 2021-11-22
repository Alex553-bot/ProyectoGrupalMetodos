package PaqueteListener;
 
// clase en duda
import java.io.IOException;
public class Hilo extends Thread{
    /**
     * The java.lang.Runtime.exec(String command) method executes the specified 
     * string command in a separate process. 
     * This is a convenience method. 
     * An invocation of the form exec(command) behaves in exactly 
     * the same way as the invocation exec(command, null, null).
     */
    public void run(String[] comandos) {
        for (String comando: comandos) {
            // este proceso termina de maner aadecuada ?
            try {
                Process p=Runtime.getRuntime().exec(comando);
                while(p.isAlive()){}
                System.out.println("ha terminado la tarea");
            } catch (IOException ioe) {
            } catch (SecurityException se) {
            } catch (IllegalArgumentException iae) {
            }
        }
    }
}
