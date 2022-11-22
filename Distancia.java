/**
 * Clase Enum Distancia las Etapas pueden tener una distancia CORTA(150), INTERMEDIA(200)
 * o LARGA(225)
 * 
 * @author Victor
 * @version 1
 */
public enum Distancia
{
    CORTA("CORTA", 150),
    INTERMEDIA("INTERMEDIA", 200),
    LARGA("LARGA", 225);
    
    private String nombre;
    private int valor;
    
    private Distancia(String nombre, int valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    

    public String getNombre(){
        return this.nombre;
    }
    
    public int getValor(){
        return this.valor;
    }
}
