/**
 * Tienen las mismas características que las Bicicletas normales, pero
 *  además, se caracterizan por tener un campo que indica la velocidad extra.
 * 
 * @author Victor
 * @version 1
 */
public class BicicletaRapida extends Bicicleta
{
    private double velocidadExtra;

    /**
     * Constructor de objetos tipo BicicletaRapida
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {
        super(nombre, peso);
        this.velocidadExtra = velocidadExtra;
    }
    
    void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    @Override
    public double calcularVelocidad(double habilidadCiclista, double dificultadEtapa){
        double velocidad = super.calcularVelocidad(habilidadCiclista, dificultadEtapa);
        velocidad = velocidad + velocidadExtra;
        return velocidad;
    }
}
