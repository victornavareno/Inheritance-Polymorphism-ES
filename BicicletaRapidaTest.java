

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class BicicletaRapidaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BicicletaRapidaTest
{
    private Etapa SencillaLarga;
    private Etapa etapa1;
    
    private Bicicleta BicicletaRapida;
    private Equipo DSMWomen;
    
    private Ciclista CiclistaNovato;
    private Ciclista CiclistaExperimentado;
    
    /**
     * Default constructor for test class BicicletaRapidaTest
     */
    public BicicletaRapidaTest()
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
    BicicletaRapida = new BicicletaRapida("CANYON Ultimate CFR eTap",Peso.LIGERA, 0.4);
    
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
    public void calcularVelocidaConCiclistaEnEtapa(){
        assertEquals(91, BicicletaRapida.calcularVelocidad(CiclistaNovato, etapa1), 0.8);
    }
    
    @Test
    public void calcularMinutosEnEtapa(){
        assertEquals(111.5, BicicletaRapida.calcularTiempo(CiclistaExperimentado, SencillaLarga), 0.5);
    }
}
