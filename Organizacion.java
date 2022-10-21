import java.util.*;
/**
 * Representa a la clase Organizacion, capaz de gestionar el campeonato.
 * 
 * @author Elena
 * @author Andrés  
 * @author Víctor e
 * @version 15.10
 */
public class Organizacion
{
    // instance variables - replace the example below with your own
    private ArrayList<Etapa> etapas;
    private ArrayList<Equipo> equipos;
    private ArrayList<Ciclista> ciclistasCarrera;
    
    /**
     * Constructor de la clase Organizacion
     */
    public Organizacion()
    {
        etapas = new ArrayList<Etapa>();
        equipos = new ArrayList<Equipo>();
        ciclistasCarrera = new ArrayList<Ciclista>();
    }
    
    
    //FUNCIONALIDAD CLASE ORGANIZACIÓN =
    /**
     * Añade un equipo al ArrayList de equipos
     * 
     * @param Objeto Equipo a añadir
     */
    public void inscribirEquipo(Equipo equipo)
    {
        equipos.add(equipo);
    }
    
    /**
     * Empieza una carrera
     * 
     * @param Objeto Equipo a añadir
     */
    public void empezarCarrera()
    {
        //INICIALIZAR ARRAYLIST ETAPAS
        
        //INICIALIZAR ARRAYLIST EQUIPOS
    }
    
    
}
