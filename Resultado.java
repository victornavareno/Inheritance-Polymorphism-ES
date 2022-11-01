
/**
 * clase Resultado, almacena los resultados obtenidos (tiempo)
 * en cada Etapa que haya disputado y que vaya disputando de la competición.
 * @author Víctor
 * @version 1
 */
public class Resultado
{
    private Etapa etapa;
    private double tiempo;

    /**
     * Constructor de la clase Resultado
     */
    public Resultado(double tiempo, Etapa etapa)
    {
        this.tiempo = tiempo;
        this.etapa = etapa;
    }
     
    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna la etapa
     * 
     * @param Etapa etapa
     */
    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }
    
      /**
     * Asigna el tiempo
     * 
     * @param double tiempo 
     */
    public void setTiempo(double tiempo) {
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
     * @return double Tiempo
     */
    public double getTiempo()
    {
        return this.tiempo;
    }
    
}
