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
    private ArrayList<Ciclista> ciclistas;
    private ArrayList<Ciclista> ciclistasAbandonado;
    private ArrayList<Bicicleta> bicicletas;

    /**
     * Constructor de la clase Equipo
     */
    public Equipo(String nombre)
    {
        this.nombre = nombre;
        ciclistas = new ArrayList<Ciclista>();
        ciclistasAbandonado = new ArrayList<Ciclista>();
        bicicletas = new ArrayList<Bicicleta>();   
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
    public ArrayList<Ciclista> getCiclistas() {
        return this.ciclistas;
    }
    
    /**
     * Devuelve la lista de ciclistas que han abandonado el equipo
     * 
     * @return ArrayList<Ciclista> con los ciclistasAbandonado
     */
    public ArrayList<Ciclista> getCiclistasAbandonado() {
        return this.ciclistasAbandonado;
    }
    
    /**
     * Devuelve la lista de bicicletas del equipo
     * 
     * @return ArrayList<Bicicleta> con las bicicletas
     */
    public ArrayList<Bicicleta> getBicicletas() {
        return this.bicicletas;
    }
    
    //MÉTODOS DE LOS ARRAYLIST:
    //Ordenando los ArrayList de ciclistas y bicicletas
    /**
     * Ordena el ArrayList de ciclistas segun criterios del ComparatorCiclistas
     * 
     * @return ArrayList<Ciclista> con los ciclistas ordenados 
     */
    public void OrdenarCiclistas(){
        System.out.println("Ordenando ciclistas por energia");  
    Collections.sort(this.ciclistas, new CiclistasComparator());
    }
    
    /**
     * Ordena el ArrayList de bicicletas segun criterios del ComparatorBicicletas
     * 
     * @return ArrayList<Bicicleta> con las bicicletas
     */
    public void OrdenarBicicletas(){
        System.out.println("Ordenando bicicletas por peso");  
    Collections.sort(this.bicicletas, new BicicletasComparator());
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

