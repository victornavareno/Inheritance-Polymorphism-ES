
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
    public BicicletaPrototipo(String nombre, Peso peso)
    {
        super(nombre, peso);
    }
    
    @Override
    public double calcularTiempo(Ciclista ciclista, Etapa etapa){
        double tiempo = etapa.getDistancia() / (super.calcularVelocidad(ciclista, etapa) * ciclista.calcularDestreza());
        
        return tiempo;
    }
    
    @Override
    public String toString(){
        return "<BicicletaPrototipo>: <peso: "+ getTipoPeso() +  "(valor: " + getPeso() + ")>";
    }
}
