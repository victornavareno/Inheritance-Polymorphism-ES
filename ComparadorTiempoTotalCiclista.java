import java.util.Comparator;
/**
 * Compara y ordena el tiempo total de 2 Ciclistas, por orden descendente
 * y en caso de empate ordena por el nombre.
 * 
 * @author Victor Navareño
 * @version 1
 */
public class ComparadorTiempoTotalCiclista implements Comparator<Ciclista>{
    public int compare(Ciclista ciclista1, Ciclista ciclista2){
            if (ciclista1.calcularTiempoTotal() > ciclista2.calcularTiempoTotal())
            return 1;
        else if (ciclista1.calcularTiempoTotal() < ciclista2.calcularTiempoTotal())
            return -1;
            
        //DESEMPATE: ORDENAMOS POR NOMBRE (función .compareTo() especial Strings)
        else
            return ciclista1.getNombre().compareTo(ciclista2.getNombre());
    } 
}
