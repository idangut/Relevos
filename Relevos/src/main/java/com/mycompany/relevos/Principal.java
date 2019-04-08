package com.mycompany.relevos;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duvan
 */
public class Principal {
        //variable donde creo un nuevo vector para el primer equipo
        static char[] equipoAmarrilo = new char[50];
        // variable donde creo un nuevo vector para el segundo equipo
        static char[] equipoAzul = new char[50];
        //variavle donde creo un nuevo verctor para el tercer equipo
        static char[] equipoRojo = new char[50];
        // variable donde se usara de condicion cuando el numero aleatorio sea 0 
        //y las posiciones que deba avanzar el jugador
        static int caido = 0;
        // variable donde se usara de condicion cuando el numero aleatorio sea 1 
        //y las posiciones que deba avanzar el jugador
        static int pequeñoPaso = 1;
        // variable donde se usara de condicion cuando el numero aleatorio sea 2 
        //y las posiciones que deba avanzar el jugador
        static int medioPaso = 2;
        // variable donde se usara de condicion cuando el numero aleatorio sea 3 
        //y las posiciones que deba avanzar el jugador
        static int granPaso = 3;
        //Variable estatica donde se usara de control
        static Integer pasosAmarillos = 0; 
        //Variable estatica donde se usara de control
        static Integer pasosAzules = 0;
        //Variable estatica donde se usara de control
        static Integer pasosRojos = 0;
        /**
         * contructor donde se hace el llenado de la matriz para cada uno
         * de los vectores anteriormente creados
         */
    public Principal() {
        llenar();
        llenarAzul();
        llenarRojo();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP1
         */
        HiloP1 per1 = new HiloP1("R.P.D", caido, pequeñoPaso, medioPaso, granPaso,pasosAmarillos, equipoAmarrilo);
        
        //per1.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP2
         */
        HiloP2 per2 = new HiloP2("R.P.D", caido, pequeñoPaso, medioPaso, granPaso, pasosAmarillos, equipoAmarrilo);
        //per2.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP3
         */
        HiloP3 per3 = new HiloP3("R.P.D", caido, pequeñoPaso, medioPaso, granPaso, pasosAmarillos, equipoAmarrilo);
        //per3.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP4
         */
       HiloP4 per4 = new HiloP4("Umbrella", caido, pequeñoPaso, medioPaso, granPaso,pasosAzules, equipoAzul);
        
      //  per4.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP5
         */
       HiloP5 per5 = new HiloP5("Umbrella", caido, pequeñoPaso, medioPaso, granPaso,pasosAzules, equipoAzul);
       // per5.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP6
         */
        HiloP6 per6 = new HiloP6("Umbrella", caido, pequeñoPaso, medioPaso, granPaso,pasosAzules, equipoAzul);
       // per6.start();
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP7
         */
        HiloP7 per7 = new HiloP7("Los Illuminados", caido, pequeñoPaso,medioPaso,granPaso,pasosRojos,equipoRojo);
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP8
         */
        HiloP8 per8 = new HiloP8("Los Illuminados", caido, pequeñoPaso,medioPaso,granPaso,pasosRojos,equipoRojo);
        /**
         * Objeto que insntacia un nuevo objeto de tipo HiloP9
         */
        HiloP9 per9 = new HiloP9("Los Illuminados", caido, pequeñoPaso,medioPaso,granPaso,pasosRojos,equipoRojo);       
        //inicio hilo 1
        //per1.start();
        //inicio hilo 4
        //per4.start();
        //inicio hilo 7
        per7.start();
        //inicio hilo 2
        //per2.start();
        //inicio hilo 5
        //per5.start();
        //inicio hilo 8
        per8.start();
        //inicio hilo 3
        //per3.start();
        //inicio hilo 6
        //per6.start();
        //inicio hilo 9
        per9.start();
        

    }
    
    public Principal(int prueba){
        
    }
    /**
     * metodo donde se genera un numero aleatorio entre 0 y 3
     * @return 
     */
    public static int generarNumero()
    {
        int numero = (int)(Math.random()* 3) + 1;
        return numero;
    }
    /**
     * metodo donde se genera un numero aleatorio entre 0 y 3
     * @return 
     */
    public static int generarNumero2()
    {
        int numero = (int)(Math.random()* 3) + 1;
        return numero;
    }
    /**
     * metodo donde se genera un numero aleatorio entre 0 y 3
     * @return 
     */
    public static int generarNumero3()
    {
        int numero = (int)(Math.random()* 3) + 1;
        return numero;
    }
    /**
     * metodo donde se hace el llenado para el vector del primer equipo
     * @return 
     */
    public boolean llenar(){
        for (int i = 0; i < 50; i++) {
            equipoAmarrilo[i] = '_';
        }//for
        if(equipoAmarrilo[0] != '_'){
            
            return false;
        }else
            return true;
    }//llenar
    /**
     * metodo donde se hace el llenado para el vector del segundo equipo
     * @return 
     */
    public void llenarAzul(){
        for (int i = 0; i < 50; i++) {
            equipoAzul[i] = '_';
        }//for
    }//llenar
    /**
     * metodo donde se hace el llenado para el vector del tercer equipo
     * @return 
     */
    private void llenarRojo(){
        for (int i = 0; i < 50; i++) {
            equipoRojo[i] = '_';
        }//for
    }//llenar
    /**
     * metodo donde se imprimen las posiciones del recorrido 
     * @param vector
     * @param numero 
     */
    public static synchronized void imprimir(char [] vector,int numero){
        
        System.out.print("\n");
        for (int i = 0; i < 50; i++) {
            switch(numero){
                case 1:
                System.out.print("\033[34m"+vector[i]);
                break;
                case 2:
                    System.out.print("\033[31m"+vector[i]);
                break;
                case 3:
                    System.out.print("\033[35m"+vector[i]);
                break;
            }
            
        }//for
        System.out.print("\n");
    }//imprimir
}
