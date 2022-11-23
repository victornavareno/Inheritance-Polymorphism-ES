/**
 * La clase Etapa representa al recorrido donde competirán cada jornada los Ciclistas con sus Bicicletas.
 * 
 * @author Víctor Navareño
 * @author Andrés
 * @author Elena
 * @version 1
 */
public class Etapa
{
    private String nombre;
    private Dificultad dificultad;
    private Distancia distancia;

    /**
     * Constructor de clase Etapa
     * @param nombre String es el nombre de la etama
     * @param dificultad Enum Dificultad mide la dureza del recorrido
     * @param distancia Enum Distancia son los kilometros a realizar en el recorrido de la Etapa
     */
    public Etapa(String nombre, Dificultad dificultad, Distancia distancia)
    {
        this.nombre= nombre;
        this.dificultad = dificultad;
        this.distancia = distancia;
    }

    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre
     * @param nombre String que especifica el nombre de la etapa
     */
    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    /**
     * Asigna la dificultad
     * @param Enum Dificultad que especifica la dificultad de la etapa
     */
    public void setDificultad (Dificultad dificultad){
        this.dificultad = dificultad;
    }

    /**
     * Asigna la distancia
     * @param Enum Distancia que especifica la distancia de la etapa
     */
    public void setDistancia (Distancia distancia){
        this.distancia = distancia;
    }

    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve el nombre
     * @return String con el nombre de la etapa
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * Devuelve la dificultad
     * @return Double con la dificultad del recorrido
     */
    public double getDificultad (){
        return dificultad.getValor();
    }

    /**
     * Devuelve la distancia
     * @return Int con la distancia recorrida en la etapa
     */
    public int getDistancia () {
        return distancia.getValor();
    }

    /**
     * Muestra las caracteristicas de etapa
     * @return String que muestra las caracteristicas de la etapa
     */
    public String toString(){
        return "<etapa: " + nombre + "> <dificultad:" + dificultad.getNombre() + "> <distancia: " + distancia.getValor() + ")>";
    }
}
