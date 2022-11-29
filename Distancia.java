/**
 * Clase Enum Distancia las Etapas pueden tener una distancia Corta(150), Intermedia(200)
 * o Larga(225)
 * 
 * @author Victor
 * @version 1
 */
public enum Distancia
{
    CORTA("Corta", 150),
    INTERMEDIA("Intermedia", 200),
    LARGA("Larga", 225);
    
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
