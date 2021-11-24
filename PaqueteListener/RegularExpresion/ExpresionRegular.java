package PaqueteListener.RegularExpresion;

import java.util.regex.*;

public class ExpresionRegular {
    private static Pattern p;
    private static Matcher m;
    public static boolean verificar(String a, String er) {
<<<<<<< HEAD
        Pattern p = Pattern.compile(".*"+er+".*");
=======
        Pattern p = Pattern.compile(er);
>>>>>>> 8342160b91befec94b922aa9d4b2b2f43b741702
        Matcher m = p.matcher(a);
        return m.matches();
    }
    public static boolean verificarTokens(String a, String b) {
        p = Pattern.compile("(.+,)*"+b+"(,.+)*");
        m = p.matcher(a.toUpperCase());
        return m.matches();
    }
    
    public boolean extensionPosible(String a) {
        p = Pattern.compile(".*");
        m = p.matcher(a);
        return m.matches();
    }
}