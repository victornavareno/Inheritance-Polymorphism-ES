import java.util.Comparator;
/**
 * Compara y ordena el tiempo medio de 2 equipos, por orden descendente
 * y en caso de empate ordena por el nombre.
 * 
 * @author Victor
 * @version 1
 */
public class ComparadorTiempoEquipo implements Comparator<Equipo>{
    public int compare(Equipo equipo1, Equipo equipo2){
            if (equipo1.calcularTiempoTotal() > equipo2.calcularTiempoTotal())
            return 1;
        else if (equipo1.calcularTiempoTotal() < equipo2.calcularTiempoTotal())
            return -1;
            
        //DESEMPATE: ORDENAMOS POR NOMBRE (función .compareTo() especial Strings)
        else
            return equipo1.getNombre().compareTo(equipo2.getNombre());
    } 
}
