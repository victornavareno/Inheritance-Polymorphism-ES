/**
 * Clase Enum Distancia las Etapas pueden tener una distancia CORTA(150), INTERMEDIA(200)
 * o LARGA(225)
 * 
 * @author Victor
 * @version 1
 */
public enum Distancia
{
    SENCILLA("CORTA", 150),
    NORMAL("INTERMEDIA", 200),
    COMPLEJA("LARGA", 225);
    
    private String nombre;
    private double valor;
    
    private Distancia(String nombre, double valor){
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
