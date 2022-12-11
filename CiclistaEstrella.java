


/**
 * Clase CiclistaEstrella, hereda de Ciclista
 * 
 * @author Victor 
 * @version 1
 */
public class CiclistaEstrella extends Ciclista implements Popular
{
    private int popularidad; // defino el cmapo popularidad único a esta clase
    
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
        setPopularidad(6);// Popularidad por defecto al empezar el campeonato es 6 al ser un ciclista estrella
    }
    
    /**
     * Asigna el valor del campo popularidad
     * 
     * @param int popularidad con el valor que queremos actualizar
     */
    private void setPopularidad(int popularidad){
        this.popularidad = popularidad;
    }
    
   /**
     * Devuelve la popularidad
     * 
     * @return int popularidad del ciclista en el momento actual
     */
    private int getPopularidad(){
        return this.popularidad;
    }
    
    /**
     * Método que calcula la destreza de un CiclistaEstrella
     * 
     * @return     destreza del ciclistaEstrella con sus condiciones actuales
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
     * @param Etapa etapa en la que el ciclista ha participado y que afectará a su popularidad
     */
    @Override
    public void serPopular(Etapa etapa){
        int popularidad = 0;
        if((obtenerTiempoEtapa(etapa) < 160.00) && (getEnergia() > 0)){
            popularidad = getPopularidad() + 4;
        }
        else {
            popularidad = this.getPopularidad() - 1;
        }
        setPopularidad(popularidad);
    }
    
    @Override
    public String toString(){
        return "<CiclistaEstrella: " + this.getNombre() + super.toString() + " <popularidad: "+ getPopularidad() +">";
    }
    
    /**
     * Hereda de la superclase Ciclista, pero añadiendo la funcionalidad SerPopular 
     * 
     * @param Etapa en la que compite el ciclista
     * @return String con el resumen de lo que ocurre en esa etapa, añadiendo el desarrollo de la popularidad del ciclista durante la misma
     */
    @Override 
    public String hacerCarrera(Etapa etapa){
            String resumenCarrera = "";
            resumenCarrera = resumenCarrera + super.hacerCarrera(etapa) + '\n';
            int popularidadAntes = getPopularidad(); // guardo la popularidad antes de actualizarla, para más tarde comprobar si ha aumentado o disminuido
            
            serPopular(etapa); // al tratarse de un ciclistaEstrella, actualizo su popularidad
            if(popularidadAntes < getPopularidad()){ // ha aumentado
                resumenCarrera = resumenCarrera +"@@@"+ '\n';
                resumenCarrera = resumenCarrera +"+++ La popularidad del ciclista " + getNombre() +" ha aumentado  y ahora su nivel de popularidad es de: "+ getPopularidad()+ " unidades" + '\n';
                resumenCarrera = resumenCarrera +"@@@" + '\n';
            }
            else{
                resumenCarrera = resumenCarrera +"@@@"+ '\n';
                resumenCarrera = resumenCarrera +"--- La popularidad del ciclista " + getNombre() +" ha disminuido  y ahora su nivel de popularidad es de: "+ getPopularidad()+ " unidades" + '\n';
                resumenCarrera = resumenCarrera +"@@@" + '\n';
            }
            return resumenCarrera;
    }
}