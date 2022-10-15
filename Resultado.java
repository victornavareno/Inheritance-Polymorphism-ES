
/**
 * clase Resultado, almacena los resultados obtenidos (tiempo)
 * en cada Etapa que haya disputado y que vaya disputando de la competición.
 * 
 * @author Victor
 * @version 14.10
 */
public class Resultado
{
    private Etapa etapa;
    private int tiempo;

    /**
     * Constructor de la clase Resultado
     */
    public Resultado(int tiempo)
    {
        this.etapa = etapa;
        this.tiempo = tiempo;
    }
     
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna la etapa
     * 
     * @param Etapa con la etapa en la que se obtiene un resultado
     */
    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }
    
      /**
     * Asigna el tiempo
     * 
     * @param nombre String con el nombre del Ciclista
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
    
    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve la etapa
     * 
     * @return Etapa etapa
     */
    public Etapa getEtapa()
    {
        return this.etapa;
    }
    
    /**
     * Devuelve el tiempo obtenido en una etapa
     * 
     * @return int Tiempo
     */
    public int getTiempo()
    {
        return this.tiempo;
    }
}
