import java.util.*;
import java.io.*;
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
    
    //PARA ESCRIBIR FICHEROS:
    FileWriter writer;


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

        //inicializo los COMPARATOR:
            this.comparadorEtapa = comparadorEtapa;
            comparadorNombreEquipo = new ComparadorNombreEquipo();
            comparadorTiempoEquipo = new ComparadorTiempoEquipo();
            comparadorTiempoCiclista = new ComparadorTiempoCiclista(); 
            comparadorTiempoTotalCiclista = new ComparadorTiempoTotalCiclista();
            
            
        // inicializo el fichero de salida
            try{
            writer  = new FileWriter("Salida.txt"); 
            }
            catch(IOException ex){
            System.out.println("Error al abrir el fichero"); 
        }
    }

    /**
     * Gestiona todo el campeonato de ciclistas
     * 
     */    
    public void gestionarCampeonato(){
        try{
        writer.write("*********************************************************************************************************" + '\n');
        writer.write("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETANDOSE TODAS LAS CARRERAS*******************" + '\n');
        writer.write("*********************************************************************************************************"+ '\n');
        writer.write('\n');
        
        }catch(IOException ex){
            System.out.println("Error al mostrar la cabecera del campeonato completo de abandonos"); 
        }
        
        mostrarEtapas();

        mostrarEquipos();
        mostrarCarreras();

        mostrarFinCampeonatoCiclistas();

        setCiclistasAbandonados(); // CARGO EL ARRAYLIST DE ABANDONADOS DE CADA EQUIPO 
        if (!ciclistasAbandonados.isEmpty()){
            mostrarAbandonados();
        }

        mostrarFinCampeonatoEquipos();
        
        //Cerramos el fichero de salida:
        try{
            writer.close();
        }
        catch(IOException ex){
            System.out.println("Error al cerrar el fichero");
        }
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
    
    /**
     * Devuelve el numero de equipos inscritos al campeonato
     * 
     * @return int numeroEquipos
     */
    public int calcularNumeroEquiposInscritos()
    {
        int numEquipos = equipos.size();
        return numEquipos;
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
        for(Equipo equipo: equipos) {
            int numCiclistas = equipo.obtenerTotalCiclistas();
            for(int j=0; j < numCiclistas; j++){
                ciclistasCarrera.add(equipo.enviarCiclista());
            }
        }
    }
    
    /**
     *  Comprueba si todos los ciclistasCarrera han abandonado
     *  
     *  @return boolean
     */
    public boolean comprobarTodosCiclistasAbandonado(){
        boolean hanAbandonado = true;
        if(!ciclistasCarrera.isEmpty()){
            for(Ciclista ciclista : ciclistasCarrera){
            if(ciclista.getAbandonado() == false){
                hanAbandonado = false;
              }
            }
        }
        return hanAbandonado;
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
        try{
            writer.write("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+'\n');
            writer.write("||||||||||||||||||| ETAPAS DEL CAMPEONATO |||||||||||||||||||"+'\n');
            writer.write("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+'\n');    
        }catch(IOException ex1){
            System.out.println("Error al mostrar la cabecera de las etapas.");
        }
        
        for(Etapa etapa : etapas){
            try{
                writer.write(etapa.toString()+ '\n');
            }catch(IOException ex2){
                System.out.println("Error al intentar mostrar las etapas");
            }
        }
        
        try{
            writer.write("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"+'\n');
            writer.write('\n');
        }catch(IOException ex3){
            System.out.println("Error al final de mostrarEtapas()");
        }
    }

    /**
     * Muestra un resumen de cada equipo que participará en el campeonato, junto con sus ciclistas
     */
    private void mostrarEquipos(){
        try{
        writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n');
        writer.write("%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%"+ '\n');
        writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+ '\n');
        }catch(IOException ex1){
            System.out.println("Error al mostrar la cabecera de los equipos");
        }

        for(Equipo equipo : equipos){
            try{
                writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+ '\n');
                writer.write((equipo.toString().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipo.calcularMediaTiempo()*100d)/100d + " %%%"+ '\n');
                writer.write('\n');
            }catch(IOException ex2){
                System.out.println("Error al mostrar los equipos");
            }

            try{
            writer.write(equipo.mostrarCiclistas());
            writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n');
            }catch(IOException ex3){
                System.out.println("Error al mostrar los ciclistas de cada equipo");
            }

        }
    }

    /**
     * Muestra todos los detalles de las diferentes carreras que se realizan, nombre de la etapa, ciclistas que participarán, posiciones tras la carrera, abandonados en cada carrera
     */
    private void mostrarCarreras(){
        int numCarrera = 1; // Indicará el índice de la carrera que estamos realizando
        for(Etapa etapa : etapas){
            
            //escribo la cabecera de la carrera
            try{
                writer.write('\n');
                anadirCiclistaCarrera();
                writer.write("********************************************************************************************************" + '\n');
                writer.write("*** CARRERA<"+ (numCarrera) + "> EN " + etapa.toString() + " ***" + '\n');   
                writer.write("********************************************************************************************************"+ '\n');
                writer.write("********************************************************************************************************"+ '\n');
                writer.write("******************************** Ciclistas que van a competir en " + etapa.getNombre() + " *******************************"+ '\n');
                writer.write("**********************************************************************************************************"+ '\n');
                Collections.sort(ciclistasCarrera, Collections.reverseOrder(comparadorTiempoTotalCiclista));
            for(Ciclista ciclista :ciclistasCarrera){
                writer.write(ciclista.toString() + '\n'); //MUESTRO LA INFO DE CADA CICLISTA QUE COMPITE EN ESTA ETAPA
            }
                
            }catch(IOException ex1){
                System.out.println("Error al mostrar la cabecera de la carrera"); // lanzo excepción si no funciona correctamente
            }
            
            //escribo el desarrollo de la carrera 
            try{
                writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ '\n');
                writer.write("+++++++++++++++++++++++++ Comienza la carrera en " + etapa.getNombre() + " ++++++++++++++++++++++++++"+ '\n');
                writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+ '\n');

            for (int j = 0; j<ciclistasCarrera.size(); j++){
                boolean tieneBicicleta = ciclistasCarrera.get(j).tieneBicicleta(); //COMPRUEBO SI TIENE BICI ASIGNADA
                String tiene;
                if(tieneBicicleta){
                    tiene = " con bicicleta";
                }
                else {
                    tiene = " sin bicicleta";
                }

                writer.write("@@@ ciclista " + (j+1) + " de "+ ciclistasCarrera.size()+ '\n');
                writer.write(ciclistasCarrera.get(j).toString() + tiene + '\n');
                if (tieneBicicleta){
                    writer.write(ciclistasCarrera.get(j).hacerCarrera(etapa) + '\n');
                    if(ciclistasCarrera.get(j).getEnergia() <= 0){
                        ciclistasAbandonados.add(ciclistasCarrera.get(j));
                    }
                }
            }
                
            }catch(IOException ex2){
                System.out.println("Error al mostrar el desarrollo de la carrera");
            }
            
            //escribo el resumen de la carrera
            try{
                writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + '\n');
                writer.write("+++++++++++++++++ Clasificación final de la carrera en "+ etapa.getNombre() +" ++++++++++++++++++" + '\n');
                writer.write("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + '\n');

                for(Ciclista ciclista: ciclistasAbandonados){ // BORRO LOS ABANDONADOS DE LOS CICLISTAS NORMALES
                if(!ciclistasAbandonados.isEmpty()){
                    ciclistasCarrera.remove(ciclista);
                    }   
                }

                for(int k = 0; k<ciclistasCarrera.size(); k++) { //BUCLE FOR, NECESITO EL INDICE
                Collections.sort(this.ciclistasCarrera, comparadorTiempoCiclista);
                writer.write("@@@ Posición(" + (k+1) + "): "+ ciclistasCarrera.get(k).getNombre() + " - Tiempo: " + Math.round(ciclistasCarrera.get(k).obtenerTiempoEtapa(etapa)*100d)/100d +" minutos @@@"+ '\n');   
                }
    
                for(Ciclista ciclista : ciclistasAbandonados){
                writer.write("¡¡¡ Ha abandonado " + ciclista.getNombre() +" - Tiempo: " + Math.round(ciclista.getEnergia()*100d)/100d + " - Además ha abandonado para el resto del Campeonato !!!"+ '\n');
                }
                writer.write('\n');
            }
            catch(IOException ex3){
                System.out.println("Error al mostrar el resumen de la carrera");
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
        try{
            writer.write("****************************************************" + '\n');
            writer.write("************** CICLISTAS QUE ABANDONARON **************"+ '\n');
            writer.write("****************************************************"+ '\n');
            for(int i = 0; i<ciclistasAbandonados.size(); i++){
            writer.write("--- ciclista Abandonado: "+ ciclistasAbandonados.get(i).getNombre() + " - Puntos Totales Anulados: "+ Math.round((ciclistasAbandonados.get(i).calcularTiempoTotal() - ciclistasAbandonados.get(i).getEnergia()) *100d)/100d +" ---" + '\n');
            for(Etapa etapa : etapas){
                if(ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapa) != 0 ){
                    writer.write("Carrera(" + etapa.getNombre()+") - Tiempo: "+ Math.round(ciclistasAbandonados.get(i).obtenerTiempoEtapa(etapa)*100d)/100d +" minutos" + '\n');
                }
            }
            writer.write('\n');
        }
            
        }catch(IOException ex1){
            System.out.println("Error al mostrar los ciclistas abandonados");
        }
    }

    /**
     * Muestra la clasificación final de los ciclistas, detallando todos sus resultados en cada etapa, tras todas las carreras
     */
    private void mostrarFinCampeonatoCiclistas(){
        try{
        writer.write("****************************************************" + '\n');
        writer.write("**************** FIN DEL CAMPEONATO ****************"+ '\n');
        writer.write("****************************************************"+ '\n');
        writer.write("********** CLASIFICACIÓN FINAL DE CICLISTAS **********"+ '\n');
        writer.write("****************************************************"+ '\n');

        Iterator<Etapa> itEtapas = etapas.iterator();
        while(itEtapas.hasNext()){
            anadirCiclistaCarrera();
            itEtapas.next();
        }

        //ORDENAR ciclistasCarrera POR TIEMPO TOTAL COMPARATOR
        Collections.sort(ciclistasCarrera, comparadorTiempoTotalCiclista);
        for(int i = 0; i < ciclistasCarrera.size(); i++){
            writer.write("@@@ Posición("+ (i+1) +"): " + ciclistasCarrera.get(i).getNombre() + " - Tiempo Total: " + Math.round(ciclistasCarrera.get(i).calcularTiempoTotal()*100d)/100d + " @@@" + '\n');
            for (Etapa etapa : etapas){
                writer.write("Carrera(" + etapa.getNombre() + ") - Tiempo: " + Math.round(ciclistasCarrera.get(i).obtenerTiempoEtapa(etapa) * 100d)/100d + " minutos"+ '\n');
            }
            writer.write('\n');
        }
            
        }catch(IOException ex1){
            System.out.println("Error al mostrar el final del campeonato");
        }
        devolverCiclistasCarrera();
    }

    /**
     * Muestra la clasificación final de los equipos, detallando todos sus ciclistas tras todas las carreras
     * 
     */
    private void mostrarFinCampeonatoEquipos(){
        Collections.sort(equipos, comparadorTiempoEquipo);
        try{
        writer.write("****************************************************" + '\n');
        writer.write("********** CLASIFICACIÓN FINAL DE EQUIPOS **********"+ '\n');
        writer.write("****************************************************"+ '\n');
        for(int k = 0; k < equipos.size(); k++){
            writer.write("@@@ Posición(" + (k+1) + ") " + equipos.get(k).getNombre() + " con " + Math.round(equipos.get(k).calcularMediaTiempo()*100d)/100d + " minutos de media @@@" + '\n');
            writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + '\n');
            writer.write("%%% "+ (equipos.get(k).getNombre().toUpperCase()) + " %%% Media Minutos de Ciclistas sin abandonar " + Math.round(equipos.get(k).calcularMediaTiempo()*100d)/100d + " %%%" + '\n');
            writer.write('\n');

            writer.write(equipos.get(k).mostrarCiclistas());
            writer.write(equipos.get(k).mostrarCiclistasAbandonados());
            writer.write("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+ '\n');
        }
            
        }catch (IOException ex1){
            System.out.println("Error al mostrar el final del campeonato completo");
        }
        
    }
}