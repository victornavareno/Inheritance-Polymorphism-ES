
/**
 * La clase Bicicleta representa a las distintas bicicletas 
 * que los Ciclistas pueden usar en las Etapas. 
 * 
 * @author Elena
 * @author Andres
 * @author Victor
 * @version 14.10
 */
public class Bicicleta
{
    // definicion de campos de la clase Bicicleta
    private String nombre;
    private int peso;
    private int velocidad;
    private int tiempo;
    
    /**
     *  Constructor parametrizado de Bicicleta
     */
    public Bicicleta(String nombre, int peso, int velocidad, int tiempo)
    {
        this. nombre = nombre;
        this.peso = peso;
        this.velocidad = velocidad; 
        this.tiempo = tiempo; 
    }
    
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre de la bicicleta
     * @param String nombreBici 
     */
    void setNombre(String nombreBici){
        this.nombre = nombreBici;
    }
    
    /**
     * Asigna el peso de la bicicleta
     * @param int pesoBici
     */
    void setPeso(int pesoBici){
        this.peso = pesoBici;
    }
    
    /**
     * Asigna la velocidad de la bicicleta
     * @param int velocidad
     */
    void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    
    /**
     * Asigna el tiempo que tarda una bicicleta en terminar la etapa
     * @param int tiempo
     */
    void setTiempo(int tiempo){
        this.tiempo = tiempo;
    }
   
    //MÉTODOS DE ACCESO(get)
    /**
     * Devuelve el nombre de la Bicicleta
     * @return Double con la distancia recorrida en la etapa
     */
    String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el peso de la Bicicleta
     * @return int peso
     */
    int getPeso(){
        return this.peso;
    }
    
    /**
     * Devuelve la velocidad de la Bicicleta
     * @return int velocidad
     */
    int getVelocidad(){
        return this.velocidad;
    }
    
    /**
     * Devuelve el tiempo para terminar una etapa de la Bicicleta
     * @return int tiempo
     */
    int getTiempo(){
        return this.tiempo;
    }
    
    //OTROS METODOS DE LA CLASE Bicicleta:
    /**
     * Muestra las características de una Bicicleta
     * @return devuelve las características de una Bicicleta
     */    
    public String toString (){
       return "Bicicleta (Nombre = " + this.nombre + ", Peso: " + this.peso + ", Velocidad: " + this.velocidad + ", Tiempo: " + this.tiempo +")";
    }
    
    /**
     *  calcular y proporcionar su velocidad cuando es usada por un Ciclista 
     *  en particular en una Etapa en concreto
     *  
     * @param  habilidadCiclista, dificultadEtapa
     * @return    velocidad
     */
    public int calcularVelocidadBicicleta(int habilidadCiclista, int dificultadEtapa)
    {
        velocidad = (habilidadCiclista * 100) / (peso * dificultadEtapa);
        return velocidad;
    }
    
    /**
     *  calcular y proporcionar el tiempo necesario (medido en minutos) para terminar
     *  la Etapa cuando es usada por un Ciclista en particular en una Etapa concreta
     
     * @param  distanciaEtapa velocidadBicicleta
     * @return    tiempo
     */
    public int calcularTiempo(int distanciaEtapa, int velocidadBicicleta)
    {
        tiempo = (distanciaEtapa / velocidadBicicleta) * 60;
        return tiempo;
    }
    
    
}