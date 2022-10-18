import java.util.Comparator;
/**
 * Compara el peso de dos Bicicletas, 
 * y en caso de empate ordena por el nombre.
 * 
 * @author Victor
 * @version 15.10
 */
class BicicletasComparator implements Comparator<Bicicleta>{
    public int compare(Bicicleta bicicleta1, Bicicleta bicicleta2){
            if (bicicleta1.getPeso() < bicicleta2.getPeso())
            return 1;
        else if (bicicleta1.getPeso() > bicicleta2.getPeso())
            return -1;
            
        //DESEMPATE: ORDENAMOS POR NOMBRE (función .compareTo() especial strings)
        else
            return bicicleta1.getNombre().compareTo(bicicleta2.getNombre()); 
    }
        }
