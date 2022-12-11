

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class OrganizacionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrganizacionTest
{
    private Etapa etapa1;
    private Etapa etapa2;
    
    private Bicicleta bicicleta1;
    private Bicicleta bicicleta2;

    private Equipo DSMWomen;
    private Equipo MovistarWomen;
    
    private Ciclista ciclista1;
    private Ciclista ciclista2;
    
    private Organizacion organizacion;
    /**
     * Default constructor for test class OrganizacionTest
     */
    public OrganizacionTest()
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
    etapa1 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
    etapa2 = new Etapa("sencilla larga", Dificultad.SENCILLA, Distancia.LARGA);
    
    
    //BICICLETAS EJEMPLO:
    bicicleta1= new Bicicleta("SCOTT CONTESSA ADDICT RC 15", Peso.PESADA);
    bicicleta2= new Bicicleta("SCOTT CONTESSA ADDICT eRIDE 15", Peso.LIGERA);
    
    //EQUIPOS EJEMPLO:
    DSMWomen = new Equipo("DSM Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);
    MovistarWomen = new Equipo("Movistar Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);
    
    
    //CICLISTAS EJEMPLO
    ciclista1 = new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, DSMWomen);
    ciclista2 = new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, DSMWomen);
    
    //NUEVA ORGANIZACION
    organizacion = new Organizacion(new ComparadorDificultadEtapa());
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
    public void inscribirEquipo(){
        organizacion.inscribirEquipo(DSMWomen);
        organizacion.inscribirEquipo(MovistarWomen);
        
        assertEquals(2, organizacion.calcularNumeroEquiposInscritos());
    }
}
