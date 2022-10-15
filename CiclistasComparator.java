import java.util.Comparator;
/**
 * Compara la energia de 2 Ciclistas, 
 * y en caso de empate ordena por el nombre.
 * 
 * @author Victor
 * @version 15.10
 */
abstract class CiclistasComparator implements Comparator<Ciclista>{
    public int compare(Ciclista ciclista1, Ciclista ciclista2){
            if (ciclista1.getEnergia() > ciclista2.getEnergia())
            return 1;
        else if (ciclista1.getEnergia() < ciclista2.getEnergia())
            return -1;
            
        //DESEMPATE: ORDENAMOS POR NOMBRE (función .compareTo() especial Strings)
        else
            return ciclista1.getNombre().compareTo(ciclista2.getNombre());
    }
        }
