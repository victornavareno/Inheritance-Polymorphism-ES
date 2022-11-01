import java.util.*;
/**
 * Representa a la clase Organizacion, capaz de gestionar el campeonato.
 * 
 * @author Víctor
 * @author Andrés  
 * @author Elena
 * @version 1
 */
public class Organizacion
{
    //ESTRUCTURAS DE DATOS IMPLEMENTADAS:
    private List<Etapa> etapas;
    private List<Equipo> equipos;
    private List<Ciclista> ciclistasCarrera;
    private List<Ciclista> ciclistasAbandonados;
    
    //ATRIBUTOS COMPARATOR
    Comparator<Etapa> comparadorEtapa;
    
    
    /**
     * Constructor parametrizado de la clase Organizacion
     * 
     * @param Comparator<Etapa> con la clase comparator que utilizaremos para ordenar el array de etapas
     */
    public Organizacion(Comparator<Etapa> comparadorEtapa)
    {
        etapas = new ArrayList<Etapa>();
        equipos = new ArrayList<Equipo>();
        ciclistasCarrera = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();
        
        //INIT COMPARATOR:
        this.comparadorEtapa = comparadorEtapa;
    }

    /**
     * Gestiona todo el campeonato de ciclistas
     * 
     */    
    public void gestionarCampeonato(){
        ordenarEtapas();
        mostrarEtapas();
        
        mostrarEquipos();
        mostrarCarreras();
        
        mostrarFinCampeonatoCiclistas();
        
        setCiclistasAbandonados();
        if (!ciclistasAbandonados.isEmpty()){
            mostrarAbandonados();
        }
        
        mostrarFinCampeonatoEquipos();
    }
    
    //CARGA EQUIPOS
    /**
     * Añade un equipo al ArrayList de equipos
     * 
     * @param Objeto Equipo a añadir
     */
    public void inscribirEquipo(Equipo equipo)
    {
        if (equipo != null){
            equipos.add(equipo);
        }
           Collections.sort(equipos,new ComparadorNombreEquipo());
    }

    //CARGA ETAPAS
    /**
     * Añade una etapa al ArrayList de etapas
     * 
     * @param Objeto Etapa a añadir
     */
    public void anadirEtapa(Etapa etapa){
        etapas.add(etapa);
    }
    
    //CARGA CICLISTAS
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista a añadir
     */
    public void anadirCiclistaCarrera(){
        for(int i=0; i < equipos.size(); i++) {
            int numCiclistas = equipos.get(i).obtenerTotalCiclistas();
        for(int j=0; j < numCiclistas; j++){
                ciclistasCarrera.add(equipos.get(i).enviarCiclista());
            }
        }
    }
    
    /**
     * Añade un ciclista al ArrayList de ciclistas
     * 
     * @param Objeto Ciclista a añadir
     */
    public void devolverCiclistasCarrera(){
        while(!ciclistasCarrera.isEmpty()){
                ciclistasCarrera.get(0).getEquipo().devolverCiclista(ciclistasCarrera.get(0));
                ciclistasCarrera.remove(0);
                }   
        while(!ciclistasAbandonados.isEmpty()){
            ciclistasAbandonados.get(0).getEquipo().devolverCiclista(ciclistasAbandonados.get(0));
            ciclistasAbandonados.remove(0);
        }
    }
    
    //MÉTODOS DE ORDENACION DE ARRAYLIST CON COMPARATOR:
    /**
     * Ordena el ArrayList de etapas segun criterios del comparadorEtapa
     * 
     * @return ArrayList<Etapa> con las etapas ordenadas 
     */
    public void ordenarEtapas(){
        Collections.sort(this.etapas, comparadorEtapa);
    }
    
    //SALIDA POR PANTALLA:
    public void mostrarEtapas(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for(Etapa etapa : etapas){
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + "\n");
    }
    
    public void mostrarEquipos(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        for(Equipo equipo : equipos){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+ (equipo.getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipo.calcularMediaTiempo()*100.00)/100.00 + " %%%");
            System.out.println();
            
            equipo.mostrarCiclistas();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
    
    public void mostrarCarreras(){
        for(int i = 0; i<etapas.size(); i++){
            anadirCiclistaCarrera();
            System.out.println("********************************************************************************************************");
            System.out.println("*** CARRERA<"+ (i+1) + "> EN <etapa:"+ etapas.get(i).getNombre() + "> <dificultad: " + etapas.get(i).getDificultad() + "> <distancia: " + etapas.get(i).getDistancia()+")> ***");   
            System.out.println("********************************************************************************************************");
            System.out.println("********************************************************************************************************");
            System.out.println("******************************** Ciclistas que van a competir en " + etapas.get(i).getNombre() + " *******************************");
            System.out.println("**********************************************************************************************************");
            Collections.sort(ciclistasCarrera,Collections.reverseOrder(new ComparadorTiempoTotalCiclista()));
            for(Ciclista ciclista :ciclistasCarrera){
                System.out.println(ciclista.toString()); //MUESTRO LA INFO DE CADA CICLISTA QUE COMPITE EN ESTA ETAPA
            }
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + etapas.get(i).getNombre() + " ++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            //ORDENAR CICLISTAS CON COMPARATOR POR TIEMPO TOTAL, EN ORDEN INVERSO
            
            
            for (int j = 0; j<ciclistasCarrera.size(); j++){
                boolean tieneBicicleta = ciclistasCarrera.get(j).tieneBicicleta(); //COMPRUEBO SI TIENE BICI ASIGNADA
                String tiene;
                if(tieneBicicleta){
                    tiene = "con bicicleta";
                }
                else {
                    tiene = "sin bicicleta";
                }
                
                System.out.println("@@@ ciclista " + (j+1) + " de "+ ciclistasCarrera.size());
                System.out.println("<ciclista:" + ciclistasCarrera.get(j).getNombre() + "> <energía: " + Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0 + "> <habilidad: " + ciclistasCarrera.get(j).getHabilidad() + "> <tiempo acumulado sin abandonar: " + Math.round(ciclistasCarrera.get(j).calcularTiempoTotal() *100.00)/100.00 + "> <abandonado:" + ciclistasCarrera.get(j).getAbandonado() + "> " + tiene );
                if (tieneBicicleta){
                    System.out.println(ciclistasCarrera.get(j).getBicicleta().toString() + ")> en etapa " + etapas.get(i).getNombre());
                    System.out.println("+++ Con estas condiciones el ciclista " + ciclistasCarrera.get(j).getNombre() + " con la bicicleta " + ciclistasCarrera.get(j).getBicicleta().getNombre() + " alcanza una velocidadad de " + Math.round(ciclistasCarrera.get(j).getBicicleta().calcularVelocidad(ciclistasCarrera.get(j).getHabilidad(), etapas.get(i).getDificultad())*100.0)/100.0 + " km/hora +++");
                    ciclistasCarrera.get(j).hacerCarrera(etapas.get(i)); //GUARDO EN EL ARRAY RESULTADOS DEL CICLISTA

                    if(ciclistasCarrera.get(j).getEnergia()<= 0){
                        System.out.println("¡¡¡ El ciclista " + ciclistasCarrera.get(j).getNombre() + " se quedó sin energia a falta de " + Math.abs(Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0) + " minutos para terminar !!!");
                        System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0 +" minutos !!!"); //TODO arreglar tiempo carrera
                        ciclistasAbandonados.add(ciclistasCarrera.get(j));
                        System.out.println("+++ La energía del ciclista "+ ciclistasCarrera.get(j).getNombre() + " tras la carrera es " + Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0 + " +++");
                        System.out.println("@@@");
                    }
                    
                    else {
                    System.out.println("+++ " + ciclistasCarrera.get(j).getNombre() +" termina la etapa en " + Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0 + " minutos +++");
                    System.out.println("+++ La energía del ciclista "+ ciclistasCarrera.get(j).getNombre() + " tras la carrera es " + Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0 + " +++");
                    System.out.println("@@@");
                    }
                }
            }
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+ etapas.get(i).getNombre() +" ++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            
            for(Ciclista ciclista: ciclistasAbandonados){ // BORRO LOS ABANDONADOS DE LOS CICLISTAS NORMALES
                if(!ciclistasAbandonados.isEmpty()){
                    ciclistasCarrera.remove(ciclista);
                }
            }
            
            for(int k = 0; k<ciclistasCarrera.size(); k++) { //BUCLE FOR, NECESITO EL INDICE
                Collections.sort(this.ciclistasCarrera, new ComparadorTiempoCiclista());
                    System.out.println("@@@ Posición(" + (k+1) + "): "+ ciclistasCarrera.get(k).getNombre() + " - Tiempo: " + Math.round(ciclistasCarrera.get(k).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0 +" minutos @@@");   
            }
            
            for(Ciclista ciclista : ciclistasAbandonados){
                System.out.println("¡¡¡ Ha abandonado " + ciclista.getNombre() +" - Tiempo: " + Math.round(ciclista.getEnergia()*100.0)/100.0 + " - Además ha abandonado para el resto del Campeonato !!!");
            }
            
            devolverCiclistasCarrera();
        }
    }
    
    public void setCiclistasAbandonados() {
        for(Equipo equipo: equipos){
            this.ciclistasAbandonados = equipo.getCiclistasAbandonado();
        }
    }
    
        public void mostrarAbandonados(){
        Collections.sort(ciclistasAbandonados, Collections.reverseOrder(new ComparadorTiempoTotalCiclista()));
        System.out.println("****************************************************");
        System.out.println("************** CICLISTAS QUE ABANDONARON **************");
        System.out.println("****************************************************");
        for(int i = 0; i<ciclistasAbandonados.size(); i++){
            System.out.println("--- ciclista Abandonado: "+ ciclistasAbandonados.get(i).getNombre() + " - Puntos Totales Anulados: "+ Math.round((ciclistasAbandonados.get(i).calcularTiempoTotal() - ciclistasAbandonados.get(i).getEnergia()) *100.0)/100.0 +" ---");
            for(int j = 0;j<etapas.size();j++){
                System.out.println("Carrera("+etapas.get(j).getNombre()+") - Tiempo: "+ Math.round(ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapas.get(j))*100.00)/100.00 +" minutos");
            }
            System.out.println();
        }
    }
    
    public void mostrarFinCampeonatoCiclistas(){
        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
        System.out.println("****************************************************");
        
        
        for(int i = 0; i<etapas.size(); i++){
            anadirCiclistaCarrera();
        }
        
        //ORDENAR ciclistasCarrera POR TIEMPO TOTAL COMPARATOR
        Collections.sort(this.ciclistasCarrera, new ComparadorTiempoTotalCiclista());
        for(int i = 0; i < ciclistasCarrera.size(); i++){
            System.out.println("@@@ Posición("+ (i+1) +"): " + ciclistasCarrera.get(i).getNombre() + " - Tiempo Total: " + Math.round(ciclistasCarrera.get(i).calcularTiempoTotal()*100.00)/100.00 + " @@@" );
            for (int j = 0; j< etapas.size(); j++){
                System.out.println("Carrera(" + etapas.get(j).getNombre() + ") - Tiempo: " + Math.round(ciclistasCarrera.get(i).obtenerTiempoEtapa(etapas.get(j)) * 100.00)/100.00 + " minutos");
            }
            System.out.println();
        }
        devolverCiclistasCarrera();
    }
    
    public void mostrarFinCampeonatoEquipos(){
               //TODO: ORDENAR EQUIPOS POR MEDIA MINUTOS EN ORDEN ASCENDENTE
        Collections.sort(equipos, new ComparadorTiempoEquipo());
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE EQUIPOS **********");
        System.out.println("****************************************************");
        for(int k = 0; k < equipos.size(); k++){
            System.out.println("@@@ Posición(" + (k+1) + ") " + equipos.get(k).getNombre() + " con " + Math.round(equipos.get(k).calcularMediaTiempo()*100.00)/100.00 + " minutos de media @@@" );
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+ (equipos.get(k).getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipos.get(k).calcularMediaTiempo()*100.00)/100.00 + " %%%");
            System.out.println();
            
            equipos.get(k).mostrarCiclistas();
            equipos.get(k).mostrarCiclistasAbandonados();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
    

}
