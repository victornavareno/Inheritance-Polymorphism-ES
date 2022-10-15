public class DatosCampeonatoCompleto
{
    
    public DatosCampeonatoCompleto(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
     private void initData(Organizacion organizacion)
    {
        // //constructor de etapas pide ( String nombre, double dificultad, double distancia)
        // Etapa etapa1 = new Etapa("sencilla larga", 0.9, 200);
        // Etapa etapa2 = new Etapa("compleja corta", 1.1, 150);
        // Etapa etapa3 = new Etapa("normal intermedia", 1.0, 175);
        // Etapa etapa4 = new Etapa("sencilla intermedia", 0.9, 175);
        // Etapa etapa5 = new Etapa("compleja intermedia", 1.1, 175);
        // Etapa etapa6 = new Etapa("normal larga", 1.0, 200);
        // organizacion.anadirEtapa(etapa1);
        // organizacion.anadirEtapa(etapa2);
        // organizacion.anadirEtapa(etapa3);
        // organizacion.anadirEtapa(etapa4);
        // organizacion.anadirEtapa(etapa5);
        // organizacion.anadirEtapa(etapa6);
        

        // //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        // Equipo movistarWomen = new Equipo("Movistar Women", //ciclistas comparados ascendentemente por habilidad (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre));
        // Equipo dSMWomen= new Equipo("DSM Women", //ciclistas comparados ascendentemente por energía (si iguales por nombre), bicicletas comparadas ascendentemente por peso (si iguales por nombre)););
        // Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women", //ciclistas comparados descendentemente por habilidad (si iguales por nombre), bicicletas comparadas descendentemente por peso (si iguales por nombre)););
        
        // organizacion.inscribirEquipo(movistarWomen);
        // organizacion.inscribirEquipo(trekSegafredoWomen);
        // organizacion.inscribirEquipo(dSMWomen);
        
		// //constructor de bicicletas pide ( String nombre, double peso)
        // dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT eRIDE 15",7.4)); 
        // dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT 15",7.6));
        // dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",7.8));
		// //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        // dSMWomen.anadirCiclista(new Ciclista("WIEBES",  4.97, 1190,dSMWomen));
        // dSMWomen.anadirCiclista(new Ciclista("LIPPERT", 5.0, 1160,dSMWomen));
        // dSMWomen.anadirCiclista(new Ciclista("LABOUS", 5.01, 1150,dSMWomen));

        // //constructor de bicicletas pide ( String nombre, double peso)  
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",7.35));
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Emonda SLR 9 eTap",7.65));
        // trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Domane SLR 9 eTap Gen 4",7.85));
        // //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        // trekSegafredoWomen.anadirCiclista(new Ciclista("BALSAMO", 4.98,1180,trekSegafredoWomen));
        // trekSegafredoWomen.anadirCiclista(new Ciclista("LONGO-BORGHINI", 4.99,1175,trekSegafredoWomen));
        // trekSegafredoWomen.anadirCiclista(new Ciclista("CORDON-RAGOT", 5.04, 1120,trekSegafredoWomen));
        
        // //constructor de bicicletas pide ( String nombre, double peso)
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Ultimate CFR eTap",7.45));
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",7.5));
        // movistarWomen.anadirBicicleta(new Bicicleta("CANYON Endurace CF SLX 9 Di2",7.75));
        // //constructor de ciclistas pide (String nombre , double habilidad , double energia, Equipo equipo)
        // movistarWomen.anadirCiclista(new Ciclista("VAN VLEUTEN", 4.96,1200,movistarWomen));
        // movistarWomen.anadirCiclista(new Ciclista("NORSGAARD", 5.02,1145,movistarWomen));
        // movistarWomen.anadirCiclista(new Ciclista("SIERRA", 5.03, 1130,movistarWomen));    

    }

}