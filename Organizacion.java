import java.util.*;
/**
 * Representa a la clase Organizacion, capaz de gestionar el campeonato.
 * 
 * @author Elena
 * @author Andrés  
 * @author Víctor e
 * @version 15.10
 */
public class Organizacion
{
    // instance variables - replace the example below with your own
    private List<Etapa> etapas;
    private List<Equipo> equipos;
    private List<Ciclista> ciclistasCarrera;
    
    /**
     * Constructor de la clase Organizacion
     */
    public Organizacion()
    {
        etapas = new ArrayList<Etapa>();
        equipos = new ArrayList<Equipo>();
        ciclistasCarrera = new ArrayList<Ciclista>();
    }
    
    
    //FUNCIONALIDAD CLASE ORGANIZACIÓN =
    
    //CARGA EQUIPOS
    /**
     * Añade un equipo al ArrayList de equipos
     * 
     * @param Objeto Equipo a añadir
     */
    public void inscribirEquipo(Equipo equipo)
    {
        equipos.add(equipo);
    }
    
    /**
     * Asigna el ArrayList de equipos
     * 
     * @param equipos ArrayList<Equipo> con los equipos que participan
     */
    public void setEquipos(ArrayList<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    //CARGA ETAPAS
    /**
     * Añade una etapa al ArrayList de etapas
     * 
     * @param Objeto Etapa a añadir
     */
    public void añadirEtapa(Etapa etapa){
        etapas.add(etapa);
    }
    
    /**
     * Asigna el ArrayList de etapas
     * 
     * @param etapas ArrayList<Etapa> con las etapas de la competición
     */
    public void setEtapas(ArrayList<Etapa> etapas) {
        this.etapas = etapas;
    }
    
    //CARGA CICLISTAS
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista a añadir
     */
    public void añadirCiclistaCarrera(Ciclista ciclista){
        ciclistasCarrera.add(ciclista);
    }
    
    /**
     * Asigna el ArrayList de ciclistas
     * 
     * @param ciclistasCarrera ArrayList<Ciclista> con los ciclistas que participarán en la carrera
     */
    public void setCiclistasCarrera(ArrayList<Ciclista> ciclistasCarrera) {
        this.ciclistasCarrera = ciclistasCarrera;
    }
    
    //MÉTODOS DE ORDENACION DE ARRAYLIST CON COMPARATOR:
    /**
     * Ordena el ArrayList de etapas segun criterios del EtapasComparator
     * 
     * @return ArrayList<Etapa> con las etapas ordenadas 
     */
    public void OrdenarEtapas(){
        Collections.sort(this.etapas, new EtapasComparator());
    }
    
    /**
     * Ordena el ArrayList de equipos segun criterios del EquiposComparator
     * 
     * @return ArrayList<Equipo> con los equipos ordenados
     */
    public void OrdenarEquipos(){
        Collections.sort(this.equipos, new EquiposComparator());
    }
    
    /**
     * Ordena el ArrayList de ciclistas segun criterios del CiclistasComparator
     * 
     * @return ArrayList<Ciclista> con los ciclistas ordenados
     */
    public void OrdenarCiclistasCarrera(){
        Collections.sort(this.ciclistasCarrera, new CiclistasComparator());
    }
    
    void mostrarEtapas(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Etapa etapa : etapas){
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }
    
    void mostrarEquipos(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        for(Equipo equipo : equipos){
            System.out.println(equipo.toString());
            System.out.println("\n");
            
            
        }
    }
        
    void gestionarCampeonato(){
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************" + "\n");
        
        
    }
    
    // public void mostrarCarrera(){
        // for(int i = 0;i<etapas.size();i++){
            // System.out.println("************************************");
            // System.out.println("* CARRERA<"+(i+1)+"> EN <etapa:"+etapas.get(i).getNombre()+"> <dificultad: "+etapas.get(i).getDificultad()+"> <distancia: "+etapas.get(i).getKilometros()+")> *");   
            // System.out.println("************************************");
            // System.out.println("************************************");
            // System.out.println("*********** Ciclistas que van a competir en "+etapas.get(i).getNombre()+" ************");
            // System.out.println("************************************");
            // for(Ciclista c:ciclistasCarrera){
                // System.out.println("<ciclista:"+c.getNombre()+"> <energía: "+Math.round(c.getEnergia()*100.0)/100.0+"> <habilidad: "+c.getHabilidad()+"> <tiempo acumulado sin abandonar:"+ Math.round(c.obtenerResultadosTotales()*100.0)/100.0+"> <abandonado:"+c.haAbandonado()+">");
            // }
            // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // System.out.println("++++++++++++++++++++++++ Comienza la carrera en "+etapas.get(i).getNombre()+" ++++++++++++++++++++++++++");
            // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // Collections.sort(ciclistasCarrera,Collections.reverseOrder(new TiempoTotalCiclistaComparator()));
            // for(int j = 0;j<ciclistasCarrera.size();j++){
                // boolean tiene = ciclistasCarrera.get(j).tieneBicicleta();
                // System.out.println("@@@ ciclista "+(j+1)+" de "+ciclistasCarrera.size());
                // System.out.print("<ciclista:"+ciclistasCarrera.get(j).getNombre()+"> <energía: "+Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0+"> <habilidad: "+ciclistasCarrera.get(j).getHabilidad()+"> <tiempo acumulado sin abandonar: "+Math.round(ciclistasCarrera.get(j).obtenerResultadosTotales()*100.0)/100.0+"> <abandonado:"+ciclistasCarrera.get(j).haAbandonado()+"> ");
                // if(tiene)
                    // System.out.println("con bicicleta");
                // else
                    // System.out.println("sin bicicleta");
                // System.out.println("<bicicleta: "+ciclistasCarrera.get(j).getBicicleta().getNombre()+"> <peso: "+ciclistasCarrera.get(j).getBicicleta().getPeso()+")> en "+etapas.get(i).getNombre());
                // System.out.println("+++ Con estas condiciones el ciclista "+ciclistasCarrera.get(j).getNombre()+" con la bicicleta "+ciclistasCarrera.get(j).getBicicleta().getNombre()+" alcanza una velocidadad de "+Math.round(ciclistasCarrera.get(j).getBicicleta().calcularVelocidad(ciclistasCarrera.get(j),etapas.get(i))*100.0)/100.0 +"km/hora +++");
                // ciclistasCarrera.get(j).guardarResultados(etapas.get(i));
                // //System.out.println("+++ "+ciclistasCarrera.get(j).getNombre()+" termina la etapa en "+ciclistasCarrera.get(j).obtenerResultado(etapas.get(i)) +"minutos +++");
                // System.out.println("+++ La energía del ciclista "+ciclistasCarrera.get(j).getNombre()+" tras la carrera es "+Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0+" +++");
                // System.out.println("@@@");
            // }
            // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+etapas.get(i).getNombre()+" ++++++++++++++++++");
            // System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            // for(int k = 0;k<ciclistasCarrera.size();k++) {
                // Collections.sort(ciclistasCarrera, new TiempoTotalCiclistaComparator());
                // System.out.println("@@@ Posición("+(k+1)+"): "+ciclistasCarrera.get(k).getNombre()+" - Tiempo: "+Math.round(ciclistasCarrera.get(k).obtenerResultado(etapas.get(i))*100.0)/100.0+" minutos @@@");
            // }
        // }
    //}
}
