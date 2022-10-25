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
    
    //CARGA EQUIPOS
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
     * Asigna el ArrayList de equipos
     * 
     * @param equipos ArrayList<Equipo> con los equipos que participan
     */
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    //CARGA ETAPAS
    /**
     * Añade una etapa al ArrayList de etapas
     * 
     * @param Objeto Etapa a añadir
     */
    public void añadirEtapa(Etapa etapa){
        etapas.add(etapa);
    }
    
    /**
     * Asigna el ArrayList de etapas
     * 
     * @param etapas ArrayList<Etapa> con las etapas de la competición
     */
    public void setEtapas(ArrayList<Etapa> etapas) {
        this.etapas = etapas;
    }
    
    //CARGA CICLISTAS
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista a añadir
     */
    public void añadirCiclistaCarrera(Ciclista ciclista){
        ciclistasCarrera.add(ciclista);
    }
    
    /**
     * Asigna el ArrayList de ciclistas
     * 
     * @param ciclistasCarrera ArrayList<Ciclista> con los ciclistas que participarán en la carrera
     */
    public void setCiclistasCarrera(ArrayList<Ciclista> ciclistasCarrera) {
        this.ciclistasCarrera = ciclistasCarrera;
    }
    
    //MÉTODOS DE MUESTRA POR TERMINAL:
    /**
     * Muestra todos los equipos inscritos
     */
    private void mostrarEquipos() {
        System.out.println("***** Listado de equipos: ");

        for (Equipo equipo : equipos) { // for each que muestra todos los equipos del ArrayList
            System.out.println(equipo + "\n");
        }
    }

    /**
     * Muestra todas las etapas
     */
    private void mostrarEtapas() {
        System.out.println("***** Listado de etapas: ");

        for (Etapa etapa : etapas) { // for each que muestra todos las etapas del ArrayList
            System.out.println(etapa + "\n");
        }
    }
    
    /**
     * Muestra todos los ciclistas inscritos
     */
    private void mostrarCiclistasCarrera() {
        System.out.println("***** Listado de ciclistas: ");

        for (Ciclista ciclista : ciclistasCarrera) { // for each que muestra todos los ciclistas del ArrayList
            System.out.println(ciclista + "\n");
        }
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
