
/**
 * La clase Bicicleta representa a las distintas bicicletas 
 * que los Ciclistas pueden usar en las Etapas. 
 * 
 * @author (your name) 
 * @version 05.10
 */
public class Bicicleta
{
    // definicion de campos de la clase Bicicleta
    private String nombreBicicleta;
    private int peso;
    
    private int velocidad;
    private int tiempo;

    /**
     * Constructor parametrizado de Bicicleta
     */
    public Bicicleta(String nombreBici, int pesoBici)
    {
        this. nombreBicicleta = nombreBici;
        this.peso = pesoBici;
    }
    

    /**
     * calcular su velocidad cuando es usada por un Ciclista 
     * en particular en una Etapa en concreto
     * 
     * @param  habilidadCiclista, dificultadEtapa
     * @return    velocidad
     */
    public int calcularVelocidadBicicleta(int habilidadCiclista, int dificultadEtapa)
    {
        this.velocidad = (habilidadCiclista * 100) / (this.peso * dificultadEtapa);
        return this.velocidad;
    }
    
    /**
     *  proporcionar el tiempo necesario (medido en minutos) para terminar
     *  la Etapa cuando es usada por un Ciclista en particular en una Etapa concreta
     
     * @param  habilidadCiclista, dificultadEtapa
     * @return    velocidad
     */
    public int calcularTiempo(int distanciaEtapa, int velocidadBicicleta)
    {
        this.tiempo = (distanciaEtapa / velocidadBicicleta) * 60;
        return this.tiempo;
    }
    
    
    
    
    
}
