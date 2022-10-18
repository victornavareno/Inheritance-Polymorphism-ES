import java.util.ArrayList;

/**
 * La clase Ciclista representa a los ciclistas que competirán con sus Bicicletas cada Etapa. La
 * diferencia entre cada Ciclista viene marcada por la diferente habilidad y energía del Ciclista.
 * 
 * @author Victor
 * @version 10.08
 */
public class Ciclista
{
    private String nombre;
    private int habilidad;
    private int energia;
    private boolean abandono;

    private Equipo equipo;
    private Bicicleta bicicleta;
    
    //Arraylist con los resultados obtenidos por el ciclista en cada etapa
    static ArrayList<Resultado> resultados;

    /**
     * Constructor de la clase Ciclista
     * 
     * @param nombre     String con el nombre del ciclista
     * @param habilidad  Int con el nivel de habilidad del ciclista
     * @param energia    Int con la energia restante del ciclista durante la competición
     * @param resultados Int con los resultados en cada etapa
     * @param abandono   Boolean para indicar si el ciclista ha abandonado o no
     * @param equipo     Equipo al que pertenece el ciclista
     * @param bicicleta  Bicicleta asignada al ciclista
     */
    public Ciclista(String nombre, int habilidad, int energia, boolean abandono, Bicicleta bicicleta, Equipo equipo)
    {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.energia = energia;
        this.abandono = abandono; 
        
        this.equipo = equipo;
        this.bicicleta = bicicleta;
        
        resultados = new ArrayList<Resultado>();
    }
    
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre
     * 
     * @param nombre String con el nombre del Ciclista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Asigna el valor de la habilidad
     * 
     * @param Int valor de la habilidad del ciclista
     */
    public void setHabilidad(int habilidad) {
        this.habilidad = habilidad;
    }
    
    /**
     * Asigna el valor de la energia
     * 
     * @param Int valor de la energia restante del ciclista
     */
    public void setEnergia(int energia) {
        this.energia = energia;
    }
               
    /**
     * Asigna el estado de abandono 
     * 
     * @param Boolean estado de abandono del ciclista en la competicion
     */
    public void setAbandono(boolean abandono) {
        this.abandono = abandono;
    }
    
    /**
     * Asigna el Equipo
     * 
     * @param Equipo asignado al ciclista
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
        
    /**
     * Asigna la Bicicleta
     * 
     * @param Bicicleta bicleta asignada al ciclista
     */
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }
    
    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve el nombre 
     * 
     * @return String con el nombre del ciclista
     */
    public String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * Devuelve la habilidad
     * 
     * @return Int con la habilidad del ciclista
     */
    public int getHabilidad()
    {
        return this.habilidad;
    }

    /**
     * Devuelve la energia 
     * 
     * @return Int con la energia restante del ciclista
     */
    public int getEnergia()
    {
        return this.energia;
    }

    /**
     * Devuelve la energia 
     * 
     * @return Int con la energia restante del ciclista
     */
    public boolean getAbandono()
    {
        return this.abandono;
    }
    
    /**
     * Devuelve el Equipo
     * @return Equipo con el equipo asignado
     */
    public Equipo getEquipo()
    {
        return this.equipo;
    }
    
    /**
     * Devuelve la Bicicleta 
     * @return Bicicleta con la bicicleta asignada
     */
    public Bicicleta getBicicleta()
    {
        return this.bicicleta;
    }
    
    //MÉTODOS CONTROL DEL ARRAYLIST de Resultados:
    /**
     * Obtiene un resultado de la colección
     * @param indice El indice del resultado que queremos obtener
     */
    public void getResultado(int indice)
    {
        if(indice >= 0 && indice < resultados.size()) {
            Resultado resultado = resultados.get(indice);
        }
    }

    /**
     * Borra un resultado de la coleccion
     * @param indice El índice del resultado a borrar
     */
    public void borrarResultado(int indice)
    {
        if(indice >= 0 && indice < resultados.size()) {
            resultados.remove(indice);
        }
    }
    
    // OTROS MÉTODOS DE LA CLASE CICLISTA:
    /**
     * muestra las características de un Ciclista
     */
    public String toString(){
        return "Ciclista (Nombre = " + this.nombre + ", Habilidad: " + this.habilidad + ", Energia: " + this.energia + ")";
    }

    /**
     * Comprueba y actualiza el estado del ciclista, si no tiene energia abandona 
     * 
     */
    public void actualizarAbandono(){
        if(this.energia > 0){
            setAbandono(false);
        }
        else{
            setAbandono(true);
        }
    }
}
