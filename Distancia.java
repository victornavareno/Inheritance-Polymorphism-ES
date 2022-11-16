
/**
 * Clase Enum Distancia las Etapas pueden tener una dificultad SENCILLA (0.9), 
 * NORMAL (1.0) o COMPLEJA (1.1)
 * 
 * @author Victor
 * @version 1
 */
public enum Distancia
{
    SENCILLA("SENCILLA", 0.9),
    NORMAL("NORMAL", 1.0),
    COMPLEJA("COMPLEJA", 1.1);
    
    private final String nombre;
    private final double valor;
    
    void Distancia(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    
}
