package PaqueteListener;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class Test_Listener.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
class Test_Listener
{
    /**
     * Default constructor for test class Test_Listener
     */
    public Test_Listener()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testParser1() {
        Parser p = new Parser();
        String[] a = {"COMANDO", "HOLA", "CERRAR"};
        String oracion = "este es una comando \n mientras      que este no lo es comando123, en caso de que este tambien funcione comando,j cerrar";
        String[] res = p.capturar(oracion,a);
        String[] pro = {"COMANDO", "CERRAR"};
        System.out.println(res[0]);System.out.println(res[1]);System.out.println(res[2]);
        
        assertEquals(res.length, 3);
    }
    
    @Test
    public void testSer() {
        Main m= new Main();
        m.agregarComando("algo",new String[]{"esto es otro"});
        m.agregarComando("esto",new String[]{"sdaf", "dsaf"});
        m.guardarTokens("/home/alex/Tokens.ser");
    }
}
