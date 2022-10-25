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
     * Añade una etapa al ArrayList de etapas
     * 
     * @param Objeto Etapa a añadir
     */
    public void añadirEtapa(Etapa etapa){
        etapas.add(etapa);
    }
    
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista a añadir
     */
    public void añadirCiclista(Ciclista ciclista){
        ciclistasCarrera.add(ciclista);
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
