
/**
 * Clase CiclistaExperimentado, hereda de Ciclista
 * 
 * @author Victor 
 * @version 1
 */
public class CiclistaExperimentado extends Ciclista
{
    /**
     * Constructor de objetos tipo CiclistaExperimentado
     * @param nombre     String con el nombre del ciclista
     * @param habilidad  Double con el nivel de habilidad del ciclista
     * @param energia    Double con la energia restante del ciclista durante la competición
     * @param equipo     Equipo al que pertenece el ciclista
     */
    public CiclistaExperimentado(String nombre, double habilidad, double energia, Equipo equipo)
    {
        super(nombre, habilidad, energia, equipo); //llamada al constructor de la superclase Ciclista
    }

    /**
     * Método que calcula la destreza de un ciclista experimentado
     * 
     * @return     destreza
     */
    @Override
    public double calcularDestreza()
    {
        double destreza;
        destreza = ((super.getHabilidad() + 4) / 130 ) * 10;
        return destreza;
    }
}
