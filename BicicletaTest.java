

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaTest.
 *
 * @author  Victor
 * @version 1
 */
public class BicicletaTest
{
    private Bicicleta BicicletaTest1;

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
    public void calcularVelocidadTest()
    {
        assertEquals(75.4, BicicletaTest1.calcularVelocidad(5.01, 0.9), 0.5);
    }
    
    @Test
    public void calcularMinutosEnEtapa()
    {
        assertEquals(159, BicicletaTest1.calcularTiempo(200, 75.5), 0.8);
    }
}


