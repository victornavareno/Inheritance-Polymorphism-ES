/**
 * Clase Enum Dificultad las Etapas pueden tener una dificultad Sencilla (0.9), 
 * Normal (1.0) o Compleja (1.1)
 * 
 * @author Victor
 * @version 1
 */
public enum Dificultad
{
    SENCILLA("Sencilla", 0.9),
    NORMAL("Normal", 1.0),
    COMPLEJA("Compleja", 1.1);
    
    private String nombre;
    private double valor;
    
    private Dificultad(String nombre, double valor){
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