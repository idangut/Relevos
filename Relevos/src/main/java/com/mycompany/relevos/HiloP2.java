package com.mycompany.relevos;
import static com.mycompany.relevos.Principal.pasosAmarillos;
import static com.mycompany.relevos.Principal.equipoAmarrilo;
import static com.mycompany.relevos.Principal.generarNumero;
import static com.mycompany.relevos.Principal.imprimir;
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
public class HiloP2 extends Thread{
    /**
    * variable que captura el equipo al cual pertenece la persona
    */
    private String equipo;
    private Integer pasosAmarillos1;
    private char[] equipoAmarillo;
    private int caido;
    private int pequeñoPaso;
    private int medioPaso;
    private int granPaso;
    private Boolean aux = false;
    /**
     * Contructor que permite instanciar la clase
     * @param equipo
     * @param caido
     * @param pequeñoPaso
     * @param medioPaso
     * @param granPaso
     * @param x
     * @param equipoAmarillo 
     */
    public HiloP2(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer x, char[] equipoAmarillo) {
    this.equipoAmarillo = equipoAmarillo;
    this.equipo = equipo;
    this.caido = caido;
    this.pequeñoPaso = pequeñoPaso;
    this.medioPaso = medioPaso;
    this.granPaso = granPaso;
    this.pasosAmarillos1 = x;
        }
        /**
        * Metodo que hace un recorrido de los vectores el cual cuando 
        * cierta variable llega hasta cierto punto, notifica al siguiente hilo en que
        * momento debe arrancar e iniciar el mismo proceso
        */
@Override
    public void run()
    {
        /**
         * validacion cuando el corredor se encuentra en la proxma posicion a hacer el cambio con el
         * siguiente corredor
         */
        if(pasosAmarillos <=17){
            try
            {
                synchronized(pasosAmarillos1)
                {
                    pasosAmarillos1.wait();
                }
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        while(!aux){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloP1.class.getName()).log(Level.SEVERE, null, ex);
                }
                int numero = generarNumero();
                if(numero == 0){  
                }else if(numero == 1){
                    recorrerUno();
                }else if(numero == 2){
                    recorrerDos();
                }else if(numero == 3){
                    recorrerTres();
                }//if
                imprimir(equipoAmarillo,1);
            }//while      
            
    }
        /**
         * metodo que recorre una cantidad de posiciones cuando el numero aleatorio
         * ha sido igual a 1
         */
    public void recorrerUno()
    {
            for (int i = pasosAmarillos; i < 50; i++) {
                        if(equipoAmarrilo[i]=='S'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+pequeñoPaso>=40){
                                equipoAmarrilo[39] ='S';
                                pasosAmarillos += pequeñoPaso;
                                synchronized(pasosAmarillos1)
                                {
                                    pasosAmarillos1.notify();                                
                                }
                                aux = true;
                                break;
                                
                            }else{
                                equipoAmarrilo[i+pequeñoPaso] ='S';
                                pasosAmarillos += pequeñoPaso;
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
             for (int i = pasosAmarillos; i < 50; i++) {
                        if(equipoAmarrilo[i]=='S'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+medioPaso >= 40){
                                equipoAmarrilo[39] ='S';
                                pasosAmarillos += medioPaso;
                                synchronized(pasosAmarillos1)
                                {
                                    pasosAmarillos1.notify();                                
                                }
                                aux = true;
                                break;
                            }else{
                                equipoAmarrilo[i+medioPaso] ='S';
                                pasosAmarillos += medioPaso;
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
            for (int i = pasosAmarillos; i < 50; i++) {
                if(equipoAmarrilo[i]=='S'){
                    equipoAmarrilo[i] = '_'; 
                        if(i+granPaso>=40){
                            equipoAmarrilo[39] ='S';
                            pasosAmarillos += granPaso;
                            synchronized(pasosAmarillos1)
                            {
                                pasosAmarillos1.notify();                                
                            }
                            aux = true;
                            break;
                            }else{
                                equipoAmarrilo[i+granPaso] ='S';
                                pasosAmarillos += granPaso;
                                break;
                        }//else
                }//if
            }//for
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
        }
