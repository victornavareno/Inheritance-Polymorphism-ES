
/**
 * Clase CiclistaEstrella, hereda de Ciclista
 * 
 * @author Victor 
 * @version 1
 */
public class CiclistaEstrella extends Ciclista
{
    /**
     * Constructor de objetos tipo CiclistaEstrella
     * @param nombre     String con el nombre del ciclista
     * @param habilidad  Enum Habilidad con el nivel de habilidad del ciclista
     * @param energia    Double con la energia restante del ciclista durante la competición
     * @param equipo     Equipo al que pertenece el ciclista
     */
    public CiclistaEstrella(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
        super(nombre, habilidad, energia, equipo); //llamada al constructor de la superclase Ciclista
        setPopularidad(6); // Popularidad por defecto al empezar el campeonato es 6 al ser un ciclista estrella
    }
    
    /**
     * Método que calcula la destreza de un CiclistaEstrella
     * 
     * @return     destreza
     */
    @Override
    public double calcularDestreza()
    {
        double destreza;
        destreza = ((super.getHabilidad() + 6) / 140 ) * 10;
        return destreza;
    }
    
    /**
     * Método que calcula y actualiza la popularidad de un ciclista tras una carrera
     * 
     */
    public void SerPopular(){
        int popularidad = 0;
        if(super.getTiempoEtapa() < 160){
            popularidad = getPopularidad() + 4;
        }
        else {
            popularidad = this.getPopularidad() - 1;
        }
        setPopularidad(popularidad);
    }
    
    @Override
    public String toString(){
        return "<CiclistaEstrella:" + this.getNombre() + super.toString() + " <popularidad: "+ getPopularidad() +">";
    }
}
