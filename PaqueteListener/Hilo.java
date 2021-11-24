package PaqueteListener;
<<<<<<< HEAD

// clase en duda
import java.io.IOException;
public class Hilo {
=======
 
// clase en duda
import java.io.IOException;
public class Hilo extends Thread{
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
    /**
     * The java.lang.Runtime.exec(String command) method executes the specified 
     * string command in a separate process. 
     * This is a convenience method. 
     * An invocation of the form exec(command) behaves in exactly 
     * the same way as the invocation exec(command, null, null).
     */
<<<<<<< HEAD
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
=======
    public void run(String[] comandos) {
        for (String comando: comandos) {
            // este proceso termina de maner aadecuada ?
            try {
                Process p=Runtime.getRuntime().exec(comando);
                System.out.println("ha empezado la tarea");
            } catch (IOException ioe) {
            } catch (SecurityException se) {
            } catch (IllegalArgumentException iae) {
                iae.printStackTrace();
            }
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
        }
    }
}
