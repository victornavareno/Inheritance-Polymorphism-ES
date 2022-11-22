/**
 * Clase Enum Habilidad, los ciclistas pueden presentar habilidad
 * LENTA (90.0), NORMAL (100.0), BUENA (110.0) o CLASEMUNDIAL (120.0)
 * 
 * @author Victor
 * @version 1
 */
public enum Habilidad
{
    LENTA ("LENTA", 90.0), 
    NORMAL ("NORMAL", 100.0), 
    BUENA ("BUENA", 110.0),
    CLASEMUNDIAL ("CLASEMUNDIAL", 120.0);
    
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
