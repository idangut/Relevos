package com.mycompany.relevos;

import static com.mycompany.relevos.Principal.generarNumero3;
    import static com.mycompany.relevos.Principal.imprimir;
    import static com.mycompany.relevos.Principal.pasosRojos;
    import java.util.logging.Level;
    import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duvan
 */
public class HiloP9 extends Thread{
    /**
     * variable que captura el equipo al cual pertenece la persona
     */
 private String equipo;
        private char[] equipoRojo;
        private int caido;
        private int pequeñoPaso;
        private int medioPaso;
        private int granPaso;
        private final Integer paso;
        private Boolean aux = false;
        /**
         * Constructor que permite instanciar la clase
         * @param equipo
         * @param caido
         * @param pequeñoPaso
         * @param medioPaso
         * @param granPaso
         * @param x
         * @param equipoAzul 
         */
        public HiloP9(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer x, char[] equipoAzul) {
            this.equipoRojo = equipoAzul;
            this.equipo = equipo;
            this.caido = caido;
            this.pequeñoPaso = pequeñoPaso;
            this.medioPaso = medioPaso;
            this.granPaso = granPaso;
            this.paso = x;
        }
        /**
        * Metodo que hace un recorrido de los vectores el cual cuando 
        * cierta variable llega hasta cierto punto, notifica al siguiente hilo en que
        * momento debe arrancar e iniciar el mismo proceso
        */
        @Override
        public void run()
        {
            
            while(!aux){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloP1.class.getName()).log(Level.SEVERE, null, ex);
                }
                int numero = generarNumero3();
                if(numero == 0){
                //aux = true;    
                }else if(numero == 1){
                    recorrerUno();
                }else if(numero == 2){
                    recorrerDos();
                }else if(numero == 3){
                    recorrerTres();
                }//if
                imprimir(equipoRojo,3);
            }//while       
        }

        /**
         * @return the equipo
         */
        public String getEquipo() {
            return equipo;
        }

        /**
         * @param equipo the equipo to set
         */
        public void setEquipo(String equipo) {
            this.equipo = equipo;
        }
        /**
        * metodo que recorre una cantidad de posiciones cuando el numero aleatorio
        * ha sido igual a 1
        */
        public void recorrerUno()
        {
            for (int i = 0; i < 50; i++) {
                        if(equipoRojo[i]=='M'){
                            equipoRojo[i] ='_'; 
                            if(i+pequeñoPaso>=50){
                                equipoRojo[49] ='M';
                                pasosRojos += pequeñoPaso;
                                synchronized(paso)
                                {
                                    paso.notify();
                                }
                                aux = true;
                                medalla();
                                break;
                            }else{
                                equipoRojo[i+pequeñoPaso] ='M';
                                pasosRojos += pequeñoPaso;
                                break;
                             }//else
                }//if
            }//for
        }
        /**
        * metodo que recorre una cantidad de posiciones cuando el numero aleatorio
        * ha sido igual a 2
        */
        public void recorrerDos()
        {
             for (int i = 0; i < 50; i++) {
                        if(equipoRojo[i]=='M'){
                            equipoRojo[i] ='_'; 
                            if(i+medioPaso >= 50){
                                equipoRojo[49] ='M';
                                pasosRojos += medioPaso;
                                synchronized(paso)
                                {
                                    //pasosAmarillos += medioPaso;
                                    paso.notify();
                                }
                                aux = true;
                                medalla();
                                break;
                            }else{
                                equipoRojo[i+medioPaso] ='M';
                                pasosRojos += medioPaso;
                                break;
                            }//else
                        }//if
                    }//for
        }
        /**
        * metodo que recorre una cantidad de posiciones cuando el numero aleatorio
        * ha sido igual a 3
        */
        public void recorrerTres()
        {
            for (int i = 0; i < 50; i++) {
                if(equipoRojo[i]=='M'){
                    equipoRojo[i] = '_'; 
                        if(i+granPaso>=50){
                            equipoRojo[49] ='M';
                            pasosRojos += granPaso;
                            synchronized(paso)
                            {
                                //pasosAmarillos += granPaso;
                                paso.notify();
                            }
                            aux = true;
                            medalla();
                            break;
                            }else{
                                equipoRojo[i+granPaso] ='M';
                                pasosRojos += granPaso;
                                break;
                        }//else
                }//if
            }//for
        }
        
        /**
         * Metodo para imprimir la medalla del ganador
         */
        public void medalla(){
        System.out.println("||||||||||||||||||||");
        System.out.println("||||||GANADOR|||||||");
        System.out.println("||||||||||||||||||||");
        System.out.println("|||EQUIPO NUMERO 3||");
        System.out.println("||||||||||||||||||||");
    }
}
