

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicicletaTest
{
    private Bicicleta BicicletaTest1;
    private Bicicleta BicicletaTest2;
    private Bicicleta BicicletaTest3;

    /**
     * Default constructor for test class BicicletaTest
     */
    public BicicletaTest()
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
        BicicletaTest1 = new Bicicleta("TREK Madone SLR 9 eTap Gen 7", 7.35);
        BicicletaTest2 = new Bicicleta("SCOTT CONTESSA ADDICT 15", 7.6);
        BicicletaTest3 = new Bicicleta("CANYON Ultimate CFR eTap", 7.45);
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


}

