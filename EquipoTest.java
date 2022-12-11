

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EquipoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EquipoTest
{
    private Etapa etapa1;
    private Etapa etapa2;
    
    private CiclistaNovato ciclista1;
    private CiclistaExperimentado ciclista2;
    
    private Bicicleta bicicleta1;
    private Bicicleta bicicleta2;
    
    private Equipo DSMWomen;
    /**
     * Default constructor for test class EquipoTest
     */
    public EquipoTest()
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
    //Inicialización de etapas =
    etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA,Distancia.LARGA);
    etapa2 = new Etapa("compleja corta", Dificultad.COMPLEJA,Distancia.CORTA);
    
    //Inicialización de ciclistas = 
    ciclista1 = new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, DSMWomen);
    ciclista2 = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, DSMWomen);
    
    //Inicializacion de bicicleta
    bicicleta1 = new Bicicleta("SCOTT CONTESSA ADDICT RC 15",Peso.PESADA);
    bicicleta2 = new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",Peso.NORMAL);
    
    //Inicialización de equipos= 
    DSMWomen = new Equipo("DSM Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);
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
    public void getMediaMinutosEquipo(){
        ciclista1.setBicicleta(bicicleta1);
        ciclista2.setBicicleta(bicicleta2);
        DSMWomen.anadirCiclista(ciclista1);
        DSMWomen.anadirCiclista(ciclista2);
        ciclista1.hacerCarrera(etapa1);
        ciclista2.hacerCarrera(etapa1);
        ciclista1.hacerCarrera(etapa2);
        ciclista2.hacerCarrera(etapa2);
        assertEquals(146, DSMWomen.calcularMediaTiempo(),0.8);
    }
    
    @Test 
    public void enviarSiguienteCiclista(){
        DSMWomen.anadirCiclista(ciclista1);
        DSMWomen.anadirCiclista(ciclista2);
        DSMWomen.anadirBicicleta(bicicleta1);
        DSMWomen.anadirBicicleta(bicicleta2);
        DSMWomen.enviarCiclista();
        assertEquals(1, DSMWomen.obtenerTotalCiclistas());
    }
}