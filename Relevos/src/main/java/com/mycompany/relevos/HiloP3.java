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
public class HiloP3 extends Thread{
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
 * contuctor que permite instanciar la clase
 * @param equipo
 * @param caido
 * @param pequeñoPaso
 * @param medioPaso
 * @param granPaso
 * @param x
 * @param equipoAmarillo 
 */

    public HiloP3(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer x, char[] equipoAmarillo) {
            this.equipoAmarillo = equipoAmarillo;
            this.equipo = equipo;
            this.caido = caido;
            this.pequeñoPaso = pequeñoPaso;
            this.medioPaso = medioPaso;
            this.granPaso = granPaso;
            this.pasosAmarillos1 = x;
        }
    @Override
    public void run()
    {
        /**
         * validacion cuando el corredor se encuentra en la proxma posicion a hacer el cambio con el
         * siguiente corredor
         */
        if(pasosAmarillos <=45){
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
                        if(equipoAmarrilo[i]=='C'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+pequeñoPaso>=50){
                                equipoAmarrilo[49] ='C';
                                pasosAmarillos += pequeñoPaso;
                                synchronized(pasosAmarillos1)
                                {
                                    pasosAmarillos1.notify();                                
                                }
                                aux = true;
                                medalla();
                                break;
                            }else{
                                equipoAmarrilo[i+pequeñoPaso] ='C';
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
                        if(equipoAmarrilo[i]=='C'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+medioPaso >= 50){
                                equipoAmarrilo[49] ='C';
                                pasosAmarillos += medioPaso;
                                synchronized(pasosAmarillos1)
                                {
                                    pasosAmarillos1.notify();                                
                                }
                                aux = true;
                                medalla();
                                break;
                            }else{
                                equipoAmarrilo[i+medioPaso] ='C';
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
                if(equipoAmarrilo[i]=='C'){
                    equipoAmarrilo[i] = '_'; 
                        if(i+granPaso>=50){
                            equipoAmarrilo[49] ='C';
                            pasosAmarillos += granPaso;
                            synchronized(pasosAmarillos1)
                            {
                                pasosAmarillos1.notify();                                
                            }
                            aux = true;
                            medalla();
                            break;
                           
                            }else{
                                equipoAmarrilo[i+granPaso] ='C';
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
    /**
    * Metodo para imprimir la medalla del ganador
    */
    public void medalla(){
        System.out.println("||||||||||||||||||||");
        System.out.println("||||||GANADOR|||||||");
        System.out.println("||||||||||||||||||||");
        System.out.println("|||EQUIPO NUMERO 1||");
        System.out.println("||||||||||||||||||||");
    }
}
