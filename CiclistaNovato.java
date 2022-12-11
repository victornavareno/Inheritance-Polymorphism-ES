

/**
 * Clase CiclistaNovato, hereda de Ciclista
 * 
 * @author Victor 
 * @version 1
 */
public class CiclistaNovato extends Ciclista
{
    /**
     * Constructor de objetos tipo CiclistaNovato
     * @param nombre     String con el nombre del ciclista
     * @param habilidad  Double con el nivel de habilidad del ciclista
     * @param energia    Double con la energia restante del ciclista durante la competición
     * @param equipo     Equipo al que pertenece el ciclista
     */
    public CiclistaNovato(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
        super(nombre, habilidad, energia, equipo); //llamada al constructor de la superclase Ciclista
    }

    /**
     * Método que calcula la destreza de un CiclistaNovato
     * 
     * @return     destreza que posee el ciclistaNovato en estas condiciones
     */
    @Override
    public double calcularDestreza()
    {
        double destreza;
        destreza = ((super.getHabilidad() + 2) / 120 ) * 10;
        return destreza;
    }
    
    @Override
    public String toString(){
        return "<CiclistaNovato:" + this.getNombre() + super.toString();
    }
}