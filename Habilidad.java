/**
 * Clase Enum Habilidad, los ciclistas pueden presentar habilidad
 * LENTA (90.0), NORMAL (100.0), BUENA (110.0) o CLASEMUNDIAL (120.0)
 * 
 * @author Victor
 * @version 1
 */
public enum Habilidad
{
    LENTA ("Lenta", 4.0), 
    NORMAL ("Normal", 6.0), 
    BUENA ("Buena", 8.0),
    CLASEMUNDIAL ("Clasemundial", 10.0); // REVISAR EL VALOR DE LA HABILIDAD
    
    private String nombre;
    private double valor;
    
    private Habilidad(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    

    public String getNombre(){
        return this.nombre;
    }
    
    public double getValor(){
        return this.valor;
    }
}
