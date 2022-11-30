/**
 * Clase Enum Peso las Etapas pueden tener una distancia Ligera: 7.35,
 * Normal: 7.50 Y Pesada: 7.85
 * 
 * @author Victor
 * @version 1
 */
public enum Peso
{
    LIGERA("Ligera", 7.35),
    NORMAL("Normal", 7.50),
    PESADA("Pesada", 7.85);
    
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
