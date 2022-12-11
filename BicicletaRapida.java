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
     * @param double velocidadExtra con la velocidad añadida a esta bicicleta por ser rapida
     */
    public BicicletaRapida(String nombre, Peso peso, double velocidadExtra)
    {
        super(nombre, peso);
        this.velocidadExtra = velocidadExtra;
    }
    
    /**
     * Asigna el valor pasado a la velocidad de esta bici
     * 
     * @param double velocidadExtra que propulsará a la bicicleta
     */
    public void setVelocidadExtra(double velocidadExtra){
        this.velocidadExtra = velocidadExtra;
    }
    
    /**
     * Devuelve la velocidad extra asignada a esta bicicletaRapida
     * 
     * @return double con la velocidad extra de la bici
     */
    public double getVelocidadExtra(){
        return this.velocidadExtra;
    }
    
    /**
     * Devuelve la velocidad que alcanza esta bicicleta con un ciclista en una etapa en concreto
     * 
     * @param Ciclista que conduce la bicicleta
     * @param Etapa en la que corre la bicicleta
     * @return double la velocidad alcanzada en esas condiciones
     */
    @Override
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa){
        double velocidad = super.calcularVelocidad(ciclista, etapa);
        velocidad = velocidad + velocidadExtra;
        return velocidad;
    }
    
    /**
     * Devuelve un string con el formato adecuado para mostrar las caracteristicas de esta BicicletaRapida
     * 
     * @return String caracteristicas de la bici rapida
     */
    @Override
    public String toString(){
        return "<BicicletaRapida: " + getNombre() + "> <peso: "+ getTipoPeso() + "(valor: " + getPeso() + ")> "+ "<velocidad extra: "+ getVelocidadExtra() + ">";
    }
}
