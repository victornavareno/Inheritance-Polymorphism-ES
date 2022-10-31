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
        
         for(Etapa etapa : etapas){
             // TODO CARGAR CICLISTAS A CICLISTASCARRERA
            anadirCiclistaCarrera();
            mostrarCarrera();
            devolverCiclistasCarrera();
         }
         // mostrarFinCampeonato();

        //mostrarCarrera();
        //mostrarFinCampeonato();
        
        //if(ciclistasAbandonados!=null) mostrarAbandonados();
        
        //mostrarClasificacionEquipos();
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
        for(int i = 0; i < equipos.size(); i++){
            if (!ciclistasCarrera.isEmpty()){
            equipos.get(i).devolverCiclista(ciclistasCarrera.get(0));
            ciclistasCarrera.remove(0);
            }
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
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        for(Equipo equipo : equipos){
            System.out.println(equipo.toString().toUpperCase() + "\n");
            
            equipo.mostrarCiclistas();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
    
    public void mostrarCarrera(){
        for(int i = 0; i<etapas.size(); i++){
            System.out.println("************************************");
            System.out.println("*** CARRERA<"+ (i+1) + "> EN <etapa:"+ etapas.get(i).getNombre() + "> <dificultad: " + etapas.get(i).getDificultad() + "> <distancia: " + etapas.get(i).getDistancia()+")> ***");   
            System.out.println("************************************");
            System.out.println("************************************");
            System.out.println("******************************** Ciclistas que van a competir en " + etapas.get(i).getNombre() + " *******************************");
            System.out.println("**********************************************************************************************************");
            for(Ciclista ciclista :ciclistasCarrera){
                System.out.println(ciclista.toString()); //MUESTRO LA INFO DE CADA CICLISTA QUE COMPITE EN ESTA ETAPA
            }
            
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + etapas.get(i).getNombre() + " ++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            //ORDENAR CICLISTAS CON COMPARATOR POR TIEMPO TOTAL, EN ORDEN INVERSO
            Collections.sort(ciclistasCarrera,Collections.reverseOrder(new ComparadorTiempoCiclista()));
            
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
                System.out.println();
                System.out.println("<ciclista:" + ciclistasCarrera.get(j).getNombre() + "> <energía: " + Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0 + "> <habilidad: " + ciclistasCarrera.get(j).getHabilidad() + "> <tiempo acumulado sin abandonar: " + Math.round(ciclistasCarrera.get(j).calcularTiempoTotal()*100.0)/100.0 + "> <abandonado:" + ciclistasCarrera.get(j).getAbandonado() + "> " + tiene );
                if (tieneBicicleta){
                    System.out.println(ciclistasCarrera.get(j).getBicicleta().toString() + ")> en etapa " + etapas.get(i).getNombre());
                    System.out.println("+++ Con estas condiciones el ciclista " + ciclistasCarrera.get(j).getNombre() + " con la bicicleta " + ciclistasCarrera.get(j).getBicicleta().getNombre() + " alcanza una velocidadad de " + Math.round(ciclistasCarrera.get(j).getBicicleta().calcularVelocidad(ciclistasCarrera.get(j).getHabilidad(), etapas.get(i).getDificultad())*100.0)/100.0 + " km/hora +++");
                    ciclistasCarrera.get(j).hacerCarrera(etapas.get(i)); //GUARDO EN EL ARRAY RESULTADOS DEL CICLISTA
                    System.out.println("+++ " + ciclistasCarrera.get(j).getNombre() +" termina la etapa en " + Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0 + " minutos +++");
                    
                    //TODO: AÑADIR MENSAJE ABANDONO
                    // FORMATO:
                    //System.out.println("¡¡¡ El ciclista "+ciclistasCarrera.get(j).getNombre()+" se quedó sin energia a falta de 48.73 minutos para terminar !!!");
                    //System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera 180.08 minutos !!!");
                
                    System.out.println("+++ La energía del ciclista "+ ciclistasCarrera.get(j).getNombre() + " tras la carrera es " + Math.round(ciclistasCarrera.get(j).getEnergia()*100.0)/100.0 + " +++");
                    System.out.println("@@@");
                }
            }
             
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+ etapas.get(i).getNombre() +" ++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            for(int k = 0; k<ciclistasCarrera.size(); k++) { //BUCLE FOR, NECESITO EL INDICE
                //ORDENAR ciclistasCarrera POR TIEMPO CON COMPARATOR, ESTA VEZ EN ORDEN NORMAL
                Collections.sort(this.ciclistasCarrera, new ComparadorTiempoCiclista());
                System.out.println("@@@ Posición(" + (k+1) + "): "+ ciclistasCarrera.get(k).getNombre() + " - Tiempo: " + Math.round(ciclistasCarrera.get(k).obtenerTiempoEtapa(etapas.get(i))*100.0)/100.0 +" minutos @@@");
            }
        }
    }
    
        public void mostrarAbandonados(){
        System.out.println("****************************************************");
        System.out.println("************** CICLISTAS QUE ABANDONARON **************");
        System.out.println("****************************************************");
        for(int i = 0; i<ciclistasAbandonados.size(); i++){
            System.out.println("--- ciclista Abandonado: "+ ciclistasAbandonados.get(i).getNombre() + " - Puntos Totales Anulados: "+ciclistasAbandonados.get(i).calcularTiempoTotal()+" ---");
            for(int j = 0;j<etapas.size();j++){
                System.out.println("Carrera("+etapas.get(j).getNombre()+") - Tiempo: "+ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapas.get(j))+" minutos");
            }
            System.out.println();
        }
    }
    
    
    public void mostrarFinCampeonato(){
        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
        System.out.println("****************************************************");
        
        //ORDENAR ciclistasCarrera POR TIEMPO TOTAL COMPARATOR
        Collections.sort(this.ciclistasCarrera, new ComparadorTiempoCiclista());
        for(int i = 0; i < ciclistasCarrera.size(); i++){
            System.out.println("@@@ Posición("+ (i+1) +"): " + ciclistasCarrera.get(i).getNombre() + " - Tiempo Total: " + Math.round(ciclistasCarrera.get(i).calcularTiempoTotal()*100.0)/100.0 + " @@@");
            for (int j = 0; j< etapas.size(); j++){
                System.out.println("Carrera(" + etapas.get(j).getNombre() + ") - Tiempo: " + Math.round(ciclistasCarrera.get(i).obtenerTiempoEtapa(etapas.get(j)) * 100.0)/100 + " minutos");
            }
        }
        System.out.println("\n");
        
        //TODO: ORDENAR EQUIPOS POR MEDIA MINUTOS EN ORDEN ASCENDENTE
        Collections.sort(equipos,Collections.reverseOrder(new ComparadorTiempoEquipo()));
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE EQUIPOS **********");
        System.out.println("****************************************************");
        for(int k = 0; k < equipos.size(); k++){
            System.out.println("@@@ Posición( " + (k+1) + ") " + equipos.get(k).getNombre() + " con " + Math.round(equipos.get(k).calcularTiempoTotal()/ etapas.size()*100.0)/100 + " minutos de media @@@");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+ (equipos.get(k).getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipos.get(k).calcularTiempoTotal()/ etapas.size()*100.0)/100 + " %%%");
            System.out.println("\n");
            
            equipos.get(k).mostrarCiclistas();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
    

}
