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
    private List<Etapa> etapas;
    private List<Equipo> equipos;
    private List<Ciclista> ciclistasCarrera;
    
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
    
    //MÉTODOS DE ORDENACION DE ARRAYLIST CON COMPARATOR:
    /**
     * Ordena el ArrayList de etapas segun criterios del EtapasComparator
     * 
     * @return ArrayList<Etapa> con las etapas ordenadas 
     */
    public void OrdenarEtapas(){
        Collections.sort(this.etapas, new EtapasComparator());
    }
    
    /**
     * Ordena el ArrayList de equipos segun criterios del EquiposComparator
     * 
     * @return ArrayList<Equipo> con los equipos ordenados
     */
    public void OrdenarEquipos(){
        Collections.sort(this.equipos, new EquiposComparator());
    }
    
    /**
     * Ordena el ArrayList de ciclistas segun criterios del CiclistasComparator
     * 
     * @return ArrayList<Ciclista> con los ciclistas ordenados
     */
    public void OrdenarCiclistasCarrera(){
        Collections.sort(this.ciclistasCarrera, new CiclistasComparator());
    }
    
    //MÉTODOS DE MUESTRA POR TERMINAL:
    /**
     * Ordena y muestra todos los equipos inscritos
     */
    private void mostrarEquipos() {
        OrdenarEquipos();
        System.out.println("***** Listado de equipos: ");

        for (Equipo equipo : equipos) { // for each que muestra todos los equipos del ArrayList
            System.out.println(equipo + "\n");
        }
    }

    /**
     * Ordena y muestra todas las etapas
     */
    private void mostrarEtapas() {
        OrdenarEtapas();
        System.out.println("***** Listado de etapas: ");

        for (Etapa etapa : etapas) { // for each que muestra todos las etapas del ArrayList
            System.out.println(etapa + "\n");
        }
    }
    
    /**
     * Ordena y muestra todos los ciclistas inscritos
     */
    private void mostrarCiclistasCarrera() {
        OrdenarCiclistasCarrera();
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
