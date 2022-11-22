
/**
 * BicicletaPrototipo tiene las mismas características que las Bicicletas normales, con algunas
 * funcionalidades extra
 * 
 * @author Victor
 * @version 1
 */
public class BicicletaPrototipo extends Bicicleta
{
    /**
     * Constructor de objetos tipo BicicletaRapida
     */
    public BicicletaPrototipo(String nombre, double peso, double destrezaCiclista)
    {
        super(nombre, peso);
    }
    
    @Override
    public double calcularTiempo(int distanciaEtapa, double velocidad){
        double tiempo = super.calcularTiempo(distanciaEtapa, velocidad);
        
        return tiempo;
    }
}
