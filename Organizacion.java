import java.util.*;
/**
 * Representa a la clase Organizacion, capaz de gestionar el campeonato.
 * 
 * @author Víctor Navareño
 * @version 1
 */
public class Organizacion
{
    //ESTRUCTURAS DE DATOS IMPLEMENTADAS:
    private Set<Etapa> etapas;
    private List<Equipo> equipos;
    private List<Ciclista> ciclistasCarrera;
    private List<Ciclista> ciclistasAbandonados;

    //ATRIBUTOS COMPARATOR
    Comparator<Etapa> comparadorEtapa;
    Comparator<Equipo> comparadorNombreEquipo;
    Comparator<Equipo> comparadorTiempoEquipo;
    Comparator<Ciclista> comparadorTiempoCiclista;
    Comparator<Ciclista> comparadorTiempoTotalCiclista;
    
    /**
     * Constructor parametrizado de la clase Organizacion
     * 
     * @param Comparator<Etapa> comparatorEtapas
     */
    public Organizacion(Comparator<Etapa> comparadorEtapa)
    {
        etapas = new TreeSet<Etapa>(comparadorEtapa);
        equipos = new ArrayList<Equipo>();
        ciclistasCarrera = new ArrayList<Ciclista>();
        ciclistasAbandonados = new ArrayList<Ciclista>();

        //INIT COMPARATOR:
            this.comparadorEtapa = comparadorEtapa;
            comparadorNombreEquipo = new ComparadorNombreEquipo();
            comparadorTiempoEquipo = new ComparadorTiempoEquipo();
            comparadorTiempoCiclista = new ComparadorTiempoCiclista(); 
            comparadorTiempoTotalCiclista = new ComparadorTiempoTotalCiclista();
    }

    /**
     * Gestiona todo el campeonato de ciclistas
     * 
     */    
    public void gestionarCampeonato(){
        mostrarEtapas();

        mostrarEquipos();
        mostrarCarreras();

        mostrarFinCampeonatoCiclistas();

        setCiclistasAbandonados(); // CARGO EL ARRAYLIST DE ABANDONADOS DE CADA EQUIPO 
        if (!ciclistasAbandonados.isEmpty()){
            mostrarAbandonados();
        }

        mostrarFinCampeonatoEquipos();
    }

    //CARGA EQUIPOS
    /**
     * Añade un equipo al ArrayList de equipos
     * 
     * @param Equipo a añadir
     */
    public void inscribirEquipo(Equipo equipo)
    {
        if (equipo != null){
            equipos.add(equipo);
        }
        Collections.sort(equipos, comparadorNombreEquipo);
    }

    //CARGA ETAPAS
    /**
     * Añade una etapa al ArrayList de etapas
     * 
     * @param Etapa etapa
     */
    public void anadirEtapa(Etapa etapa){
        etapas.add(etapa);
    }

    //CARGA CICLISTAS
    /**
     * Añade un ciclista al ArrayList de ciclistasCarrera
     * 
     */
    private void anadirCiclistaCarrera(){
        for(int i=0; i < equipos.size(); i++) {
            int numCiclistas = equipos.get(i).obtenerTotalCiclistas();
            for(int j=0; j < numCiclistas; j++){
                ciclistasCarrera.add(equipos.get(i).enviarCiclista());
            }
        }
    }

    /**
     * Vuelca todos los ciclistas que aún no han abandonado en su equipo correspondiente
     * 
     */
    private void devolverCiclistasCarrera(){
        while(!ciclistasCarrera.isEmpty()){
            ciclistasCarrera.get(0).getEquipo().devolverCiclista(ciclistasCarrera.get(0));
            ciclistasCarrera.remove(0);
        }   
        while(!ciclistasAbandonados.isEmpty()){
            ciclistasAbandonados.get(0).getEquipo().devolverCiclista(ciclistasAbandonados.get(0));
            ciclistasAbandonados.remove(0);
        }
    }

    //SALIDA POR PANTALLA:
    /**
     * Muestra los detalles de todas las etapas (Formato especificado en toString etapa)
     */
    private void mostrarEtapas(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");

        for(Etapa etapa : etapas){
            System.out.println(etapa.toString());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||" + "\n");
    }

    /**
     * Muestra un resumen de cada equipo que participará en el campeonato, junto con sus ciclistas
     */
    private void mostrarEquipos(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        for(Equipo equipo : equipos){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+ (equipo.getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipo.calcularMediaTiempo()*100d)/100d + " %%%");
            System.out.println();

            equipo.mostrarCiclistas();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    /**
     * Muestra todos los detalles de las diferentes carreras que se realizan, nombre de la etapa, ciclistas que participarán, posiciones tras la carrera, abandonados en cada carrera
     */
    private void mostrarCarreras(){
        int numCarrera = 1; // Indicará el índice de la carrera que estamos realizando
        for(Etapa etapa : etapas){
            System.out.println();
            anadirCiclistaCarrera();
            System.out.println("********************************************************************************************************");
            System.out.println("*** CARRERA<"+ (numCarrera) + "> EN " + etapa.toString() + " ***");   
            System.out.println("********************************************************************************************************");
            System.out.println("********************************************************************************************************");
            System.out.println("******************************** Ciclistas que van a competir en " + etapa.getNombre() + " *******************************");
            System.out.println("**********************************************************************************************************");
            Collections.sort(ciclistasCarrera, Collections.reverseOrder(comparadorTiempoTotalCiclista));
            for(Ciclista ciclista :ciclistasCarrera){
                System.out.println(ciclista.toString()); //MUESTRO LA INFO DE CADA CICLISTA QUE COMPITE EN ESTA ETAPA
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


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
                System.out.println("<ciclista:" + ciclistasCarrera.get(j).getNombre() + "> <energía: " + Math.round(ciclistasCarrera.get(j).getEnergia()*100d)/100d + "> <habilidad: " + ciclistasCarrera.get(j).getHabilidad() + "> <tiempo acumulado sin abandonar: " + Math.round(ciclistasCarrera.get(j).calcularTiempoTotal() *100d)/100d + "> <abandonado:" + ciclistasCarrera.get(j).getAbandonado() + "> " + tiene );
                if (tieneBicicleta){
                    double tiempoHastaAbandono; // PARA ALMACENAR LA ENERGIA DE LA CARRERA ANTERIOR, QUE COINCIDIRÁ CON EL TIEMPO QUE INVIERTE EN QUEDARSE SIN ENERGIA EN LA SIGUIENTE
                    tiempoHastaAbandono = ciclistasCarrera.get(j).getEnergia();
                    System.out.println(ciclistasCarrera.get(j).getBicicleta().toString() + " en etapa " + etapa.getNombre());
                    System.out.println("+++ Con estas condiciones el ciclista " + ciclistasCarrera.get(j).getNombre() + " con la bicicleta " + ciclistasCarrera.get(j).getBicicleta().getNombre() + " alcanza una velocidad de " + Math.round(ciclistasCarrera.get(j).getBicicleta().calcularVelocidad(ciclistasCarrera.get(j), etapa)*100d)/100d + " km/hora +++");
                    ciclistasCarrera.get(j).hacerCarrera(etapa); //GUARDO EN EL ARRAY RESULTADOS DEL CICLISTA

                    if(ciclistasCarrera.get(j).getEnergia()<= 0){
                        System.out.println("¡¡¡ El ciclista " + ciclistasCarrera.get(j).getNombre() + " se quedó sin energia a falta de " + Math.abs(Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapa)*100d)/100d) + " minutos para terminar !!!");
                        System.out.println("¡¡¡ En el momento de quedarse sin energia llevaba en carrera " + Math.round(tiempoHastaAbandono *100d)/100d +" minutos !!!"); //TODO arreglar tiempo carrera
                        ciclistasAbandonados.add(ciclistasCarrera.get(j));
                        System.out.println("+++ La energía del ciclista "+ ciclistasCarrera.get(j).getNombre() + " tras la carrera es " + Math.round(ciclistasCarrera.get(j).getEnergia()*100d)/100d + " +++");
                        
                    }

                    else {
                        System.out.println("+++ " + ciclistasCarrera.get(j).getNombre() +" termina la etapa en " + Math.round(ciclistasCarrera.get(j).obtenerTiempoEtapa(etapa)*100d)/100d + " minutos +++");
                        System.out.println("+++ La energía del ciclista "+ ciclistasCarrera.get(j).getNombre() + " tras la carrera es " + Math.round(ciclistasCarrera.get(j).getEnergia()*100d)/100d + " +++");
                        System.out.println("@@@");
                        System.out.println("@@@");
                        System.out.println("+++ La popularidad del ciclista " + ciclistasCarrera.get(j).getNombre() +" ha aumentado  y ahora su nivel de popularidad es de: "+ ciclistasCarrera.get(j).getPopularidad()+ "unidades" );
                        System.out.println("@@@");
                    }
                }
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+ etapa.getNombre() +" ++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            for(Ciclista ciclista: ciclistasAbandonados){ // BORRO LOS ABANDONADOS DE LOS CICLISTAS NORMALES
                if(!ciclistasAbandonados.isEmpty()){
                    ciclistasCarrera.remove(ciclista);
                }
            }

            for(int k = 0; k<ciclistasCarrera.size(); k++) { //BUCLE FOR, NECESITO EL INDICE
                Collections.sort(this.ciclistasCarrera, comparadorTiempoCiclista);
                System.out.println("@@@ Posición(" + (k+1) + "): "+ ciclistasCarrera.get(k).getNombre() + " - Tiempo: " + Math.round(ciclistasCarrera.get(k).obtenerTiempoEtapa(etapa)*100d)/100d +" minutos @@@");   
            }

            for(Ciclista ciclista : ciclistasAbandonados){
                System.out.println("¡¡¡ Ha abandonado " + ciclista.getNombre() +" - Tiempo: " + Math.round(ciclista.getEnergia()*100d)/100d + " - Además ha abandonado para el resto del Campeonato !!!");
            }
            devolverCiclistasCarrera();
            numCarrera++; //actualizo el indice de la carrera siguiente
        }
    }

    /**
     * Asigna la concatenación de ArrayList de ciclistas abandonados de cada equipo a la lista de ciclistasAbandonados de la organizacion
     */
    private void setCiclistasAbandonados() {
        for(Equipo equipo: equipos){
            ciclistasAbandonados.addAll(equipo.getCiclistasAbandonado());
        }
    }

    /**
     * Muestra la lista de los ciclistas que han abandonado por falta de energía tras realizar todas las carreras
     */
    private void mostrarAbandonados(){
        Collections.sort(ciclistasAbandonados, comparadorTiempoTotalCiclista); //Collections.S(comparadorTiempoTotalCiclista));
        System.out.println("****************************************************");
        System.out.println("************** CICLISTAS QUE ABANDONARON **************");
        System.out.println("****************************************************");
        for(int i = 0; i<ciclistasAbandonados.size(); i++){
            System.out.println("--- ciclista Abandonado: "+ ciclistasAbandonados.get(i).getNombre() + " - Puntos Totales Anulados: "+ Math.round((ciclistasAbandonados.get(i).calcularTiempoTotal() - ciclistasAbandonados.get(i).getEnergia()) *100d)/100d +" ---");
            for(Etapa etapa : etapas){
                if(ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapa) != 0 ){
                    System.out.println("Carrera(" + etapa.getNombre()+") - Tiempo: "+ Math.round(ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapa)*100d)/100d +" minutos");
                }
            }
            System.out.println();
        }
    }

    /**
     * Muestra la clasificación final de los ciclistas, detallando todos sus resultados en cada etapa, tras todas las carreras
     */
    private void mostrarFinCampeonatoCiclistas(){
        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS **********");
        System.out.println("****************************************************");

        Iterator<Etapa> itEtapas = etapas.iterator();
        while(itEtapas.hasNext()){
            anadirCiclistaCarrera();
            itEtapas.next();
        }

        //ORDENAR ciclistasCarrera POR TIEMPO TOTAL COMPARATOR
        Collections.sort(ciclistasCarrera, comparadorTiempoTotalCiclista);
        for(int i = 0; i < ciclistasCarrera.size(); i++){
            System.out.println("@@@ Posición("+ (i+1) +"): " + ciclistasCarrera.get(i).getNombre() + " - Tiempo Total: " + Math.round(ciclistasCarrera.get(i).calcularTiempoTotal()*100d)/100d + " @@@" );
            for (Etapa etapa : etapas){
                System.out.println("Carrera(" + etapa.getNombre() + ") - Tiempo: " + Math.round(ciclistasCarrera.get(i).obtenerTiempoEtapa(etapa) * 100d)/100d + " minutos");
            }
            System.out.println();
        }
        devolverCiclistasCarrera();
    }

    /**
     * Muestra la clasificación final de los equipos, detallando todos sus ciclistas tras todas las carreras
     * 
     */
    private void mostrarFinCampeonatoEquipos(){
        Collections.sort(equipos, comparadorTiempoEquipo);
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE EQUIPOS **********");
        System.out.println("****************************************************");
        for(int k = 0; k < equipos.size(); k++){
            System.out.println("@@@ Posición(" + (k+1) + ") " + equipos.get(k).getNombre() + " con " + Math.round(equipos.get(k).calcularMediaTiempo()*100d)/100d + " minutos de media @@@" );
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+ (equipos.get(k).getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipos.get(k).calcularMediaTiempo()*100d)/100d + " %%%");
            System.out.println();

            equipos.get(k).mostrarCiclistas();
            equipos.get(k).mostrarCiclistasAbandonados();
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }
}
