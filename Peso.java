/**
 * Clase Enum Peso las Etapas pueden tener una distancia LIGERA: 7.35,
 * NORMAL: 7.50 Y PESADA: 7.85
 * 
 * @author Victor
 * @version 1
 */
public enum Peso
{
    LIGERA("LIGERA", 7.35),
    NORMAL("NORMAL", 7.50),
    PESADA("PESADA", 7.85);
    
    private String nombre;
    private double valor;
    
    private Peso(String nombre, double valor){
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
