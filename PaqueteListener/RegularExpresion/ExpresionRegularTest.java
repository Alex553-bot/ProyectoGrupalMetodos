package PaqueteListener.RegularExpresion;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ExpresionRegularTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExpresionRegularTest
{
    /**
     * Default constructor for test class ExpresionRegularTest
     */
    public ExpresionRegularTest()
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
    public void test1() {
        String a = "aafsdkf,kafds,EL,a";
        String token = "EL";
        assertTrue(ExpresionRegular.verificarTokens(a, token));
    }
}
