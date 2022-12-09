public class DatosCampeonatoCompletoFinal
{
    
    public DatosCampeonatoCompletoFinal(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
     private void initData(Organizacion organizacion)
    {
        //constructor de etapas pide ( String nombre, double dificultad, double distancia)
        Etapa etapa1 = new Etapa("sencilla larga", Dificultad.SENCILLA,Distancia.LARGA);
        Etapa etapa2 = new Etapa("compleja corta", Dificultad.COMPLEJA,Distancia.CORTA);
        Etapa etapa3 = new Etapa("normal intermedia", Dificultad.NORMAL,Distancia.INTERMEDIA);
        Etapa etapa4 = new Etapa("sencilla intermedia", Dificultad.SENCILLA, Distancia.INTERMEDIA);
        Etapa etapa5 = new Etapa("compleja intermedia", Dificultad.COMPLEJA, Distancia.INTERMEDIA);
        Etapa etapa6 = new Etapa("normal larga", Dificultad.NORMAL, Distancia.LARGA);
        organizacion.anadirEtapa(etapa1);
        organizacion.anadirEtapa(etapa2);
        organizacion.anadirEtapa(etapa3);
        organizacion.anadirEtapa(etapa4);
        organizacion.anadirEtapa(etapa5);
        organizacion.anadirEtapa(etapa6);
        

        //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        Equipo movistarWomen = new Equipo("Movistar Women", new ComparadorPesoBicicleta(), new ComparadorHabilidadCiclista(), false, false); //ciclistas comparados ascendentemente por habilidad (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre)
        Equipo dSMWomen = new Equipo("DSM Women", new ComparadorPesoBicicleta(), new ComparadorEnergiaCiclista(), false, false);//ciclistas comparados ascendentemente por energía (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre))
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women", new ComparadorPesoBicicleta(), new ComparadorHabilidadCiclista(), true, true);//ciclistas comparados descendentemente por habilidad (si iguales por nombre), bicicletas comparadas descendentemente por peso (si iguales por nombre)););
        
        organizacion.inscribirEquipo(movistarWomen);
        organizacion.inscribirEquipo(trekSegafredoWomen);
        organizacion.inscribirEquipo(dSMWomen);
        
        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        dSMWomen.anadirBicicleta(new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15",Peso.LIGERA, 0.3)); 
        dSMWomen.anadirBicicleta(new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",Peso.NORMAL));
        dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",Peso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        dSMWomen.anadirCiclista(new CiclistaNovato("WIEBES",  Habilidad.NORMAL, 1190, dSMWomen));
        dSMWomen.anadirCiclista(new CiclistaEstrella("LIPPERT", Habilidad.NORMAL, 1160, dSMWomen));
        dSMWomen.anadirCiclista(new CiclistaExperimentado("LABOUS", Habilidad.BUENA, 1150, dSMWomen));

        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",Peso.LIGERA));
        trekSegafredoWomen.anadirBicicleta(new BicicletaRapida("TREK Emonda SLR 9 eTap",Peso.NORMAL, 0.5));
        trekSegafredoWomen.anadirBicicleta(new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",Peso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        trekSegafredoWomen.anadirCiclista(new CiclistaEstrella("BALSAMO", Habilidad.NORMAL,1180, trekSegafredoWomen));
        trekSegafredoWomen.anadirCiclista(new CiclistaExperimentado("LONGO-BORGHINI", Habilidad.NORMAL,1175, trekSegafredoWomen));
        trekSegafredoWomen.anadirCiclista(new CiclistaNovato("CORDON-RAGOT", Habilidad.BUENA, 1120, trekSegafredoWomen));
        
        //constructor de bicicletas pide ( String nombre, Peso peso)
        //constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        movistarWomen.anadirBicicleta(new BicicletaRapida("CANYON Ultimate CFR eTap",Peso.LIGERA, 0.4));
        movistarWomen.anadirBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",Peso.NORMAL));
        movistarWomen.anadirBicicleta(new BicicletaPrototipo("CANYON Endurace CF SLX 9 Di2",Peso.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        movistarWomen.anadirCiclista(new CiclistaEstrella("VAN VLEUTEN", Habilidad.NORMAL,1200, movistarWomen));
        movistarWomen.anadirCiclista(new CiclistaExperimentado("NORSGAARD", Habilidad.NORMAL,1145, movistarWomen));
        movistarWomen.anadirCiclista(new CiclistaNovato("SIERRA", Habilidad.BUENA, 1130, movistarWomen));   

    }

}