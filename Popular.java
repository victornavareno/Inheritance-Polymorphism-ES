
/**
 * Interfaz que define los métodos necesarios para implementar un sistema de popularidad 
 * 
 * @author Victor
 * @version 1
 */

public interface Popular
{
    /**
     * Calcula y actualiza la popularidad para cada etapa del campeonato en el que se implementa
     * 
     * @param  Etapa con la etapa en la que el participante ha competido 
     */
    void serPopular(Etapa etapa);
}