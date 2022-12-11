
/**
 * La clase Bicicleta representa a las distintas bicicletas 
 * que los Ciclistas pueden usar en las Etapas. 
 * 
 * @author Víctor
 * @version 1
 */
public class Bicicleta
{
    // definicion de campos de la clase Bicicleta
    private String nombre;
    private Peso peso;

    /**
     *  Constructor parametrizado de Bicicleta
     *  @param String nombre de la bicicleta
     *  @param Peso enum con las especificaciones del peso de la bici
     */
    public Bicicleta(String nombre, Peso peso)
    {
        this.nombre = nombre;
        this.peso = peso;
        
        if(nombre == null){
        throw new IllegalArgumentException(
            "El nombre de la bicicleta no puede ser nulo.");
        }
        
        if(peso == null){
        throw new IllegalArgumentException(
           "El peso de la bicicleta no puede ser nulo.");
        }
            
        if(this.nombre.length() == 0 ) { // controlo que el nombre tenga un valor no vacio ""
            throw new IllegalStateException("El nombre no debe estar inicializado a una cadena vacia.");
        }
    }

    //MÉTODOS MODIFICADORES (set)
    /**
     * Asigna el nombre de la bicicleta
     * @param String nombre con el nombre de la bicicleta
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Asigna el peso de la bicicleta
     * @param Peso con el peso que queremos asignar
     */
    public void setPeso(Peso peso){
        this.peso = peso;
    }

    //MÉTODOS DE ACCESO(get)
    /**
     * Devuelve el nombre de la Bicicleta
     * @return String con el nombre de la bicicleta
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el peso de la Bicicleta
     * @return Peso con el peso de la bicicleta
     */
    public double getPeso(){
        return this.peso.getValor();
    }
    
    /**
     * Devuelve el nombre del tipo de peso de la bicicleta
     * @return 
     */
    public String getTipoPeso(){
        return peso.getNombre();
    }


    //OTROS METODOS DE LA CLASE Bicicleta:
    /**
     * Muestra las características de una Bicicleta
     * @return devuelve las características de una Bicicleta
     */ 
    @Override
    public String toString (){
        return "<Bicicleta: " + this.getNombre() +  "> <peso: "+ peso.getNombre() +  "(valor: " + getPeso() + ")>";
    }

    /**
     *  calcular y proporcionar su velocidad cuando es usada por un Ciclista 
     *  en particular en una Etapa en concreto
     *  
     * @param  Ciclista ciclista, Etapa etapa
     * @return    double velocidad
     */
    public double calcularVelocidad(Ciclista ciclista, Etapa etapa)
    {
        double velocidad = (ciclista.getHabilidad() * 100) / (peso.getValor() * etapa.getDificultad());
        return velocidad;
    }

    /**
     *  calcular y proporcionar el tiempo necesario (medido en minutos) para terminar
     *  la Etapa cuando es usada por un Ciclista en particular en una Etapa concreta
     
     * @param  Ciclista ciclista, Etapa etapa 
     * @return    double tiempo
     */
    public double calcularTiempo(Ciclista ciclista, Etapa etapa)
    {
        double tiempo = (etapa.getDistancia() / calcularVelocidad(ciclista, etapa)) * 60;
        return tiempo;
    }

    /**
     * Comprueba que la bicicleta pasada es igual que el nativo comparando sus campos, return false si algún valor distinto
     * 
     * @param Object con el objeto a comparar // en este caso tipo Bicicleta
     * @return boolean si ambos objetos son iguales en contenido
     */
    @Override
    public boolean equals(Object obj){        
        if(this == obj) {
            return true; //Ambos referencian al mismo objeto
        }
        if(!(obj instanceof Bicicleta)) {
            return false; //Tienen diferentes tipos
        }
        Bicicleta other = (Bicicleta) obj;
        
        // comparo cada campo significativo de
        // this y other:
        // return true si todos los valores iguales
        // return false si algún valor distinto
        if (getNombre() != other.getNombre()){
            return false;
        }
        if (getPeso() != other.getPeso()){
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
        int result = 7; // definimos numero primo
        result = 3 * result + getNombre().hashCode();
        return result;
    }
}