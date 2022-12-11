
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
    
    
    /**
     * Devuelve el tiempo empleado por un ciclista en una etapa con esta bici
     * 
     * @param Ciclista que conducirá esta bicicleta
     * @param Etapa en la que corre la bicicletaPrototipo
     * @return double tiempo alcanzado en estas condiciones
     */
    @Override
    public double calcularTiempo(Ciclista ciclista, Etapa etapa){
        double tiempo = etapa.getDistancia() / (super.calcularVelocidad(ciclista, etapa) * ciclista.calcularDestreza());
        
        return tiempo;
    }
    
    /**
     * Devuelve un string con el formato adecuado para mostrar las caracteristicas de esta BicicletaPrototipo
     * 
     * @return String caracteristicas de la bici prototipo
     */
    @Override
    public String toString(){
        return "<BicicletaPrototipo: " + getNombre() + "> <peso: "+ getTipoPeso() +  "(valor: " + getPeso() + ")>";
    }
}
