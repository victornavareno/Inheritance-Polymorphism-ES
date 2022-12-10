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
    
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    public double getVelocidadExtra(){
        return this.velocidadExtra;
    }
    
    @Override
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa){
        double velocidad = super.calcularVelocidad(ciclista, etapa);
        velocidad = velocidad + velocidadExtra;
        return velocidad;
    }
    
    @Override
    public String toString(){
        return "<BicicletaRapida: " + getNombre() + "> <peso: "+ getTipoPeso() + "(valor: " + getPeso() + ")> "+ "<velocidad extra: "+ getVelocidadExtra() + ">";
    }
}
