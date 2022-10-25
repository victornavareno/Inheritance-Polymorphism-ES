import java.util.*;
/**
 * Representa los Equipos que competirán tanto por ganar la clasificación por Equipos como que
 * uno de sus Ciclistas gane el campeonato individual de Ciclistas.
 * 
 * @author Elena
 * @author Victor
 * @author Andres
 * @version 09.10
 */
public class Equipo
{
    private String nombre;
    private List<Ciclista> ciclistas;
    private List<Ciclista> ciclistasAbandonado;
    private List<Bicicleta> bicicletas;
    
    
    // CAMPOS COMPARATOR
    Comparator<Bicicleta> comparadorBicicleta;
    Comparator<Ciclista> comparadorCiclista;
    private boolean ordenarOrdenInversoBicicleta;
    private boolean ordenarOrdenInversoCiclista; 

    /**
     * Constructor de la clase Equipo
     */
    public Equipo(String nombre, Comparator<Bicicleta> comparadorBicicleta, Comparator<Ciclista> comparatorCiclista, boolean ordenarOrdenInversoBicicleta, boolean ordenarOrdenInversoCiclista)
    {
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonado = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();   
    
        this.comparadorBicicleta = comparadorBicicleta;
        this.comparadorCiclista = comparatorCiclista;
        this.ordenarOrdenInversoBicicleta = ordenarOrdenInversoBicicleta;
        this.ordenarOrdenInversoCiclista = ordenarOrdenInversoCiclista;
    }
    
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre del Equipo
     * 
     * @param nombre String con el nombre del Equipo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Asigna la lista de ciclistas actuales del Equipo
     * 
     * @param competidores ArrayList<Ciclista> con los ciclistas
     */
    public void setCiclistas(ArrayList<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }
    
    /**
     * Asigna la lista de ciclistas que han abandonado
     * 
     * @param eliminados ArrayList<Ciclista> con los abandonados 
     */
    public void setEliminados(ArrayList<Ciclista> ciclistasAbandonado) {
        this.ciclistasAbandonado = ciclistasAbandonado;
    }

    /**
     * Asigna la lista de bicicletas de las que dispone el Equipo
     * 
     * @param bicicletas ArrayList<Bicicleta> con las bicicletas
     */
    public void setBicicletas(ArrayList<Bicicleta> bicicletas) {
        this.bicicletas = bicicletas;
    }
    
    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve el nombre del Equipo
     * 
     * @return String con el nombre del Equipo
     */
    public synchronized String getNombre() {
        return this.nombre;
    }
    
    /**
     * Devuelve la lista de ciclistas actuales del equipo
     * 
     * @return ArrayList<Ciclista> con los ciclistas 
     */
    public List<Ciclista> getCiclistas() {
        return this.ciclistas;
    }
    
    /**
     * Devuelve la lista de ciclistas que han abandonado el equipo
     * 
     * @return ArrayList<Ciclista> con los ciclistasAbandonado
     */
    public List<Ciclista> getCiclistasAbandonado() {
        return this.ciclistasAbandonado;
    }
    
    /**
     * Devuelve la lista de bicicletas del equipo
     * 
     * @return ArrayList<Bicicleta> con las bicicletas
     */
    public List<Bicicleta> getBicicletas() {
        return this.bicicletas;
    }
    
    //MÉTODOS DE LOS ARRAYLIST:
    /**
     * Añade una bicicleta al arraylist
     * 
     * @param Objeto Bicicleta con la bicicleta a introducir
     */
    public void añadirBicicleta(Bicicleta bicicleta){
        this.bicicletas.add(bicicleta);
    }
    
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista con el ciclista a introducir
     */
    public void añadirCiclista(Ciclista ciclista){
        this.ciclistas.add(ciclista);
    }

    //Ordenando los ArrayList de ciclistas y bicicletas
    /**
     * Ordena el ArrayList de ciclistas segun criterios del comparadorCiclista
     * 
     * @return ArrayList<Ciclista> con los ciclistas ordenados 
     */
    public void OrdenarCiclistas(){
        System.out.println("Ordenando ciclistas");  
        if(this.ordenarOrdenInversoCiclista == true){      
            Collections.sort(this.ciclistas, Collections.reverseOrder(comparadorCiclista)); // ORDENO EN ORDEN INVERSO
        }
        else Collections.sort(this.ciclistas, comparadorCiclista); // ORDEN NORMAL
    }
    
    /**
     * Ordena el ArrayList de bicicletas segun criterios del comparadorBicicleta
     * 
     * @return ArrayList<Bicicleta> con las bicicletas
     */
    public void OrdenarBicicletas(){
        System.out.println("Ordenando bicicletas");
        if(this.ordenarOrdenInversoBicicleta == true){      
            Collections.sort(this.bicicletas, Collections.reverseOrder(comparadorBicicleta)); // ORDENO EN ORDEN INVERSO
        }
        else Collections.sort(this.bicicletas, comparadorBicicleta); // ORDEN NORMAL
    }
    
    /**
     * Calcula el total del tiempo obtenido en todas las etapas por todos los ciclistas del equipo
     * 
     * @return Int tiempoTotalEquipo con la suma del tiempo de todos los ciclistas en todas las etapas
     */
    public int calcularTiempoTotal(){
        int tiempoTotalEquipo = 0;
        for (Ciclista ciclista : ciclistas){ // BUCLE FOR EACH QUE RECORRE EL ARRAY DE CICLISTAS DEL  EQUIPO
            tiempoTotalEquipo = tiempoTotalEquipo + ciclista.calcularTiempoTotal();
        }   
        return tiempoTotalEquipo;
    }
    
        
    //ENVIAR CICLISTAS
    // public void enviarCiclista(){
      // OrdenarCiclistas();
      // OrdenarBicicletas();
      
      
    // }
    
    // public void devolverCiclista(Ciclista ciclista){
        // this.ciclistas
    // }
    
    
    
    public void enviarCiclistas(){
        for(int indice = 0; indice <= ciclistas.size(); indice ++){
            if(ciclistas.get(indice).getAbandono() == true){
                ciclistasAbandonado.add(ciclistas.get(indice)); // SI HA ABANDONADO, LO AÑADIMOS AL ARRAY ABANDONADOS
                ciclistas.remove(indice);  // SI HA ABANDONADO, LO BORRAMOS DEL ARRAY CICLISTAS
            }
            else{
                //TODO:          IMPLEMENTACIÓN DE 
                //Debe ser capaz de enviar en cada Etapa a sus Ciclistas sin abandonar junto con las
                //Bicicletas asignadas. Se considera que un equipo siempre tendrá al menos tantas
                //Bicicletas como Ciclistas tenga el Equipo..
            }
            
        }
    }
}

