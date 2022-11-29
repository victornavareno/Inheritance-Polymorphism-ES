
/**
 * BicicletaPrototipo tiene las mismas características que las Bicicletas normales, con algunas
 * funcionalidades extra
 * 
 * @author Victor
 * @version 1
 */
public class BicicletaPrototipo extends Bicicleta
{
    private double destrezaCiclista;
    /**
     * Constructor de objetos tipo BicicletaRapida
     */
    public BicicletaPrototipo(String nombre, Peso peso, double destrezaCiclista)
    {
        super(nombre, peso);
        this.destrezaCiclista = destrezaCiclista;
    }
    
    @Override
    public double calcularTiempo(Ciclista ciclista, Etapa etapa){
        double tiempo = etapa.getDistancia() / super.calcularVelocidad(ciclista, etapa) * ciclista.calcularDestreza();
        
        return tiempo;
    }
}
