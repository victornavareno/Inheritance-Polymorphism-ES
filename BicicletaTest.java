

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
    private Etapa SencillaLarga;
    private Etapa etapa1;
    
    private Bicicleta BicicletaNormal;
    private Equipo DSMWomen;
    
    private Ciclista CiclistaNovato;
    private Ciclista CiclistaExperimentado;
    
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
    //modelo fixture para objetos en módulos de prueba=
    //ETAPAS EJEMPLO:
    SencillaLarga = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
    etapa1 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
    
    //BICICLETAS EJEMPLO:
    BicicletaNormal = new Bicicleta("SCOTT CONTESSA ADDICT RC 15", Peso.PESADA);
    
    //EQUIPOS EJEMPLO:
    DSMWomen = new Equipo("DSM Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);
    
    //CICLISTAS EJEMPLO
    CiclistaNovato = new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, DSMWomen);
    CiclistaExperimentado = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, DSMWomen);
    
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


