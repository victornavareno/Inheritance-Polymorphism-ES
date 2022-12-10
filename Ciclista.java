import java.util.*;

/**
 * La clase Ciclista representa a los ciclistas que competirán con sus Bicicletas cada Etapa. La
 * diferencia entre cada Ciclista viene marcada por la diferente habilidad y energía del Ciclista.
 * 
 * @author Victor
 * @version 1
 */
abstract class Ciclista
{
    private String nombre;
    private Habilidad habilidad;
    private double energia;
    private boolean abandonado;
    
    private Etapa etapa;
    private Equipo equipo;
    private Bicicleta bicicleta;

    //HashMap con los resultados obtenidos por el ciclista en cada etapa
    private Map<Etapa, Double> resultado1; // Declaro el mapa resultados, donde su clave será una etapa y su contenido el double tiempo obtenido en esa etapa

    /**
     * Constructor de la clase Ciclista
     * 
     * @param nombre     String con el nombre del ciclista
     * @param habilidad  Enum Habilidad con el nivel de habilidad del ciclista
     * @param energia    Double con la energia restante del ciclista durante la competición
     * @param abandonado   Boolean para indicar si el ciclista ha abandonado o no
     * @param equipo     Equipo al que pertenece el ciclista
     * @param bicicleta  Bicicleta asignada al ciclista
     */
    public Ciclista(String nombre, Habilidad habilidad, double energia, Equipo equipo)
    {
        this.nombre = nombre;
        this.habilidad = habilidad;
        this.energia = energia;

        this.equipo = equipo;        
        resultado1 = new HashMap<>();
    }

    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre
     * 
     * @param nombre String con el nombre del Ciclista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna el valor de la habilidad
     * 
     * @param Double valor de la habilidad del ciclista
     */
    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }

    /**
     * Asigna el valor de la energia
     * 
     * @param Double valor de la energia restante del ciclista
     */
    public void setEnergia(double energia) {
        this.energia = energia;
    }

    /**
     * Asigna el estado de abandonado 
     * 
     * @param Boolean estado de abandonado del ciclista en la competicion
     */
    public void setAbandonado(boolean abandonado) {
        this.abandonado = abandonado;
    }

    /**
     * Asigna el Equipo
     * 
     * @param Equipo asignado al ciclista
     */
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    /**
     * Asigna la Bicicleta
     * 
     * @param Bicicleta bicleta asignada al ciclista
     */
    public void setBicicleta(Bicicleta bicicleta) {
        this.bicicleta = bicicleta;
    }

    //MÉTODOS DE ACCESO (get)
    /**
     * Devuelve el nombre 
     * 
     * @return String con el nombre del ciclista
     */
    public String getNombre()
    {
        return this.nombre;
    }

    /**
     * Devuelve la habilidad
     * 
     * @return Double con la habilidad del ciclista
     */
    public double getHabilidad()
    {
        return this.habilidad.getValor();
    }

    /**
     * Devuelve la energia 
     * 
     * @return double con la energia restante del ciclista
     */
    public double getEnergia()
    {
        return this.energia;
    }

    /**
     * Devuelve el resultado en su última etapa
     * 
     * @return double con el tiempo obtenido en la ultima etapa
     */
    protected double getTiempoEtapa(){
        double tiempoUltimaEtapa = 0;
        for (double tiempo : resultado1.values()){
            tiempoUltimaEtapa = tiempo;
        }    
        return tiempoUltimaEtapa;
    }

    /**
     * Devuelve el estado de abandonado del ciclista 1 abandonado 0 no abandonado
     * 
     * @return Boolean true si el ciclista ha abandonado
     */
    public boolean getAbandonado()
    {
        return this.abandonado;
    }

    /**
     * Devuelve el Equipo
     * @return Equipo con el equipo asignado
     */
    public Equipo getEquipo()
    {
        return this.equipo;
    }

    /**
     * Devuelve la Bicicleta 
     * @return Bicicleta con la bicicleta asignada
     */
    public Bicicleta getBicicleta()
    {
        return this.bicicleta;
    }
    
    //MÉTODOS CONTROL DEL HASMAP de Resultados:
    /**
     * Encuentra y devuelve el resultado obtenido en una etapa en concreto
     * @param Etapa la etapa de la cual queremos conocer el tiempo resultado
     * @return double tiempo obtenido en la etapa
     */
    public double obtenerTiempoEtapa(Etapa etapa){
        double tiempoEtapa = 0;
        if(resultado1.containsKey(etapa)){
            tiempoEtapa = resultado1.get(etapa);
        }//else exception
        return tiempoEtapa;
    }

    /**
     * Devuelve el numero de etapas en las que ha participado el ciclista, incluye la etapa en la que abandona
     * @return Int total de etapas
     */
    private int obtenerTotalEtapas(){
        return this.resultado1.size();
    }

    /**
     * Devuelve el numero de etapas que ha terminado el ciclista, no incluye la etapa en la que abandona
     * @return Int total de etapas completadas
     */
    protected int obtenerTotalEtapasTerminadas(){
        int totalEtapasTerminadas = 0;
        if(getAbandonado() == true){
            totalEtapasTerminadas = resultado1.size() - 1;
        }
        else {
            totalEtapasTerminadas = resultado1.size();
        }
        return totalEtapasTerminadas;
    }

    /**
     * Calcula el tiempo total empleado por un ciclista en todas sus etapas completadas
     * @return double tiempo obtenido en todas las etapas que completa
     */
    protected double calcularTiempoTotal(){
        actualizarAbandono();
        double tiempoTotal = 0;

        for (double tiempo : resultado1.values()){
            tiempoTotal = tiempoTotal + tiempo;
        }     
        return tiempoTotal;
    }

    /**
     * Devuelve la etapa final del ciclista, en la que abandona
     * @return Etapa etapa en la que el ciclista abandona
     */
    protected Etapa obtenerEtapaAbandonado(){
        if(getAbandonado() == true){
            return null;
        }
        else return null;
    }

    // OTROS MÉTODOS DE LA CLASE CICLISTA:

    /**
     * Indica si el ciclista posee una bicicleta asignada o no
     * 
     * @return boolean estado de asignación de la Bicicleta (true: tiene bicicleta asignada, false: no tiene)
     */
    public boolean tieneBicicleta(){
        boolean tiene;
        if(this.bicicleta.equals(null)){
            tiene = false;
        }
        else {
            tiene = true;
        }
        return tiene;
    }

    /**
     * muestra las características de un Ciclista
     * 
     * @return String con los atributos del ciclista en formato de salida correcto
     */
    @Override
    public String toString(){               
        return "> <energía: " + Math.round(energia*100d)/100d + "> <habilidad: " + habilidad.getNombre() +" (valor:" + habilidad.getValor() + ")> <tiempo acumulado sin abandonar: " + Math.round(calcularTiempoTotal()*100d)/100d + "> <abandonado: " + abandonado +">";
    }

    /**
     * Comprueba que el ciclista pasado es igual que el nativo comparando sus campos, return false si algún valor distinto
     * 
     * @param Object obj
     * @return boolean 
     */
    public boolean equals(Object obj){        
        if(this == obj) {
            return true; //Ambos referencian al mismo objeto
        }
        if(!(obj instanceof Bicicleta)) {
            return false; //Tienen diferentes tipos
        }
        Ciclista other = (Ciclista) obj;
        
        // ... compara cada campo significativo de
        // this y other:
        // return true si todos los valores iguales
        // return false si algún valor distinto
        if (getNombre() != other.getNombre()){
            return false;
        }
        if (getEnergia() != other.getEnergia()){
            return false;
        }
        if (getHabilidad() != other.getHabilidad()){
            return false;
        }
        if (!(getBicicleta().equals(other.getBicicleta()))){
            return false;
        }
        return true;
    }
    
    /**
    * Técnica de generación de hashcode, según se indica en el libro:
    * Effective Java by Joshua Bloch.
    */
    @Override
    public int hashCode()
    {
        int result = 17; // definimos numero primo
        result = 3 * result + getNombre().hashCode();
        return result;
    }

    /**
     * Comprueba y actualiza el estado del ciclista, si no tiene energia abandonado pasa a ser true
     * 
     */
    protected void actualizarAbandono(){
        if(this.energia > 0){
            setAbandonado(false);
        }
        else{
            setAbandonado(true);
        }
    }

    /**
     * Calcula y actualiza la energía del ciclista
     * 
     */
    protected void actualizarEnergia(Etapa etapa){
        energia = energia - bicicleta.calcularTiempo(this, etapa);
        setEnergia(energia);
    }

    /**
     * Calcula y actualiza los resultados (tiempo) de un ciclista en una etapa en concreto utilizando su bicicleta (participar en una carrera)
     * 
     * @param Etapa en la que participa
     */
    public String hacerCarrera(Etapa etapa){
        double velocidadBicicleta = bicicleta.calcularVelocidad(this, etapa); // CALCULO LA VELOCIDAD QUE ALCANZARÁ EL CICLISTA PARA ESTA ETAPA CON LA BICICLETA
        double tiempoCarrera = bicicleta.calcularTiempo(this, etapa); // CALCULO EL TIEMPO QUE TARDARÁ EL CICLISTA CON LA BICICLETA PARA ESA ETAPA
        String resumenCarrera = "";
        
        actualizarEnergia(etapa); //CON EL TIEMPO DE LA ETAPA, CALCULO Y ACTUALIZO LA ENERGIA DEL CICLISTA
        actualizarAbandono();

        if (!this.abandonado){ // NO HA ABANDONADO
            resultado1.put(etapa, tiempoCarrera); // AÑADO UN NUEVO RESULTADO AL HASHMAP
        }
        else{
            resultado1.put(etapa, this.energia); // SE HA QUEDADO SIN ENERGIA, INSERTAMOS EL TIEMPO NEGATIVO EN EL ARRAY RESULTADOS
        }
        
        
        //nuevo:
        double tiempoHastaAbandono; // PARA ALMACENAR LA ENERGIA DE LA CARRERA ANTERIOR, QUE COINCIDIRÁ CON EL TIEMPO QUE INVIERTE EN QUEDARSE SIN ENERGIA EN LA SIGUIENTE
        tiempoHastaAbandono = getEnergia();
        resumenCarrera = resumenCarrera + (getBicicleta().toString() + " en etapa " + etapa.getNombre()) + '\n';
        resumenCarrera = resumenCarrera + "+++ Con estas condiciones el ciclista " + getNombre() + " con la bicicleta " + getBicicleta().getNombre() + " alcanza una velocidad de " + Math.round(getBicicleta().calcularVelocidad(this, etapa)*100d)/100d + " km/hora +++" + '\n';

        if(getEnergia()<= 0){
            resumenCarrera = resumenCarrera + "¡¡¡ El ciclista " + getNombre() + " se quedó sin energia a falta de " + Math.abs(Math.round(obtenerTiempoEtapa(etapa)*100d)/100d) + " minutos para terminar !!!" + '\n';
            resumenCarrera = resumenCarrera + "¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + Math.round(tiempoHastaAbandono *100d)/100d +" minutos !!!" + '\n'; 
            resumenCarrera = resumenCarrera + "+++ La energía del ciclista "+ getNombre() + " tras la carrera es " + Math.round(getEnergia()*100d)/100d + " +++" + '\n';
        }

        else {
            resumenCarrera = resumenCarrera + "+++ " + getNombre() +" termina la etapa en " + Math.round(obtenerTiempoEtapa(etapa)*100d)/100d + " minutos +++" + '\n';
            resumenCarrera = resumenCarrera + "+++ La energía del ciclista "+ getNombre() + " tras la carrera es " + Math.round(getEnergia()*100d)/100d + " +++" + '\n';
            resumenCarrera = resumenCarrera + "@@@";
        }
        return resumenCarrera;
    }
    
    /**
     * Calcula la destreza del ciclista
     * @return destreza 
     */
    abstract double calcularDestreza();
}