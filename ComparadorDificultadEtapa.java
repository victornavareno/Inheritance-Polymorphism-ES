import java.util.Comparator;
/**
 * Compara y ordena por la dificultad de 2 Etapas, en orden descendente,
 * y en caso de empate ordena por el nombre.
 * 
 * @author Victor
 * @version 15.10
 */
class ComparadorDificultadEtapa implements Comparator<Etapa>{
    public int compare(Etapa etapa1, Etapa etapa2){
            if (etapa1.getDificultad() > etapa2.getDificultad())
            return 1;
        else if (etapa1.getDificultad() < etapa2.getDificultad())
            return -1;
            
        //DESEMPATE: ORDENAMOS POR NOMBRE (función .compareTo() especial Strings)
        else
            return etapa1.getNombre().compareTo(etapa2.getNombre());
    }
        }
