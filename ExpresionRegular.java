import java.util.regex.*;
public class ExpresionRegular {
    private Pattern p;
    private Matcher m;
    public boolean verificar(String a, String er) {
        Pattern p = Pattern.compile(er);
        Matcher m = p.matcher(a);
        return m.matches();
    }
    public boolean verificarTokens(String a,final String b) {
        p = Pattern.compile("^"+b);
        m = p.matcher(a.toUpperCase());
        return m.matches();
    }
}
