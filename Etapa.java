
/**
 * La clase Etapa representa al recorrido donde competirán 
 * cada jornada los Ciclistas con sus Bicicletas.
 * 
 * @author (your name) 
 * @version 05.10
 */
public class Etapa
{
    // campos de la clase Etapa
    private String nombre;
    private int dificultad;
    private int distancia;

    /**
     * Constructor parametrizado de la clase Etapa
     */
    public Etapa(String nombreEtapa, int dificultadEtapa, int distanciaEtapa)
    {
        this.nombre = nombreEtapa;
        this.dificultad = dificultadEtapa;
        this.distancia = distanciaEtapa;
        
    }

    /**
     * metodos get de la clase etapa:
     */
    public String getNombreEtapa(){
        return this.nombre;
    }
    
    public int getDificultadEtapa(){
        return this.dificultad;
    }
    
    public int getDistanciaEtapa(){
        return this.distancia;
    }
}