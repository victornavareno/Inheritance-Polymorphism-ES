

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
    //ETAPAS EJEMPLO:
    Etapa SencillaLarga = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
    Etapa etapa1 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
    
    //BICICLETAS EJEMPLO:
    Bicicleta BicicletaNormal = new Bicicleta("SCOTT CONTESSA ADDICT RC 15", Peso.PESADA);
    
    //EQUIPOS EJEMPLO:
    Equipo DSMWomen = new Equipo("DSM Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);
    
    //CICLISTAS EJEMPLO
    CiclistaNovato CiclistaNovato = new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, DSMWomen);
    CiclistaExperimentado CiclistaExperimentado = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, DSMWomen);
    
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
    public void calcularVelocidadConCiclistaEnEtapa()
    {
        assertEquals(84.93, BicicletaNormal.calcularVelocidad(CiclistaNovato, SencillaLarga), 0.7);
    }

    @Test
    public void calcularMinutosEnEtapa()
    {
 
        assertEquals(105.98, BicicletaNormal.calcularTiempo(CiclistaExperimentado, etapa1), 0.6);
    }
}


