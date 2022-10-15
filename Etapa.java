/**
 * Write a description of class Etapa here.
 * 
 * @author Elena Chacon Viniegra
 * @author Victor 
 * @author Andres Leo Santiago
 * @version 1
 */
public class Etapa
{
    private String nombre;
    private double dificultad;
    private int distancia;

    /**
     * Constructor de clase Etapa
     * @param nombre String es el nombre de la etama
     * @param dificultad Double mide la dureza del recorrido
     * @param distancia Double son los kilometros a realizar en el recorrido de la Etapa
     */
    public Etapa(String nombre, double dificultad, int distancia)
    {
        this.nombre= nombre;
        this.dificultad = dificultad;
        this.distancia = distancia;
    }
    
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre
     * @param nombre String que especifica el nombre de la etapa
     */
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Asigna la dificultad
     * @param dificultad Int que especifica la dificultad de la etapa
     */
    public void setDificultad (int dificultad){
        this.dificultad = dificultad;
    }
    
    /**
     * Asigna la distancia
     * @param distancia Double que especifica la distancia de la etapa
     */
    public void setDistancia (int distancia){
        this.distancia = distancia;
    }
    
    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve el nombre
     * @return String con el nombre de la etapa
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Devuelve la dificultad
     * @return Double con la dificultad del recorrido
     */
    public double getDificultad (){
        return dificultad;
    }
    
    /**
     * Devuelve la distancia
     * @return Int con la distancia recorrida en la etapa
     */
    public int getDistancia () {
        return distancia;
    }
    
    //OTROS MÉTODOS DE LA CLASE Etapa:
    /**
     * muestra las características de una Etapa
     */
    void mostrar(){
        System.out.println("Etapa: " + this.nombre);
        System.out.println("Dificultad: " + this.dificultad);
        System.out.println("Distancia: " + this.distancia);
    }
    
}
