package PaqueteListener;

// clase en duda
import java.io.IOException;
public class Hilo {
    /**
     * The java.lang.Runtime.exec(String command) method executes the specified 
     * string command in a separate process. 
     * This is a convenience method. 
     * An invocation of the form exec(command) behaves in exactly 
     * the same way as the invocation exec(command, null, null).
     */
    // de igual manera se puede usar ProcessBuilder 
    public void run(String[] comandos) {
        try {
            Process p=Runtime.getRuntime().exec(comandos);
            System.out.println("ha empezado la tarea");
        } catch (IOException ioe) {
        } catch (SecurityException se) {
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            //}
        }
    }
}
