package com.mycompany.relevos;
import static com.mycompany.relevos.Principal.generarNumero2;
import static com.mycompany.relevos.Principal.equipoAzul;
import static com.mycompany.relevos.Principal.imprimir;
import static com.mycompany.relevos.Principal.pasosAzules;
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
public class HiloP6 extends Thread{
    /**
     * variable que captura el equipo al cual pertenece la persona
     */
    private String equipo;
    private Integer pasosAzules1;
    private char[] equipoAzul;
    private int caido;
    private int pequeñoPaso;
    private int medioPaso;
    private int granPaso;
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
    public HiloP6(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer x, char[] equipoAzul) {
    this.equipoAzul = equipoAzul;
    this.equipo = equipo;
    this.caido = caido;
    this.pequeñoPaso = pequeñoPaso;
    this.medioPaso = medioPaso;
    this.granPaso = granPaso;
    this.pasosAzules1 = x;
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
        if(pasosAzules <=46){
            try
            {
                synchronized(pasosAzules1)
                {
                    pasosAzules1.wait();
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
                int numero = generarNumero2();
                if(numero == 0){  
                }else if(numero == 1){
                    recorrerUno();
                }else if(numero == 2){
                    recorrerDos();
                }else if(numero == 3){
                    recorrerTres();
                }//if
                imprimir(equipoAzul,2);
            }//while      
            
    }
    /**
    * metodo que recorre una cantidad de posiciones cuando el numero aleatorio
    * ha sido igual a 1
    */
    public void recorrerUno()
    {
            for (int i = pasosAzules; i < 50; i++) {
                        if(equipoAzul[i]=='O'){
                            equipoAzul[i] ='_'; 
                            if(i+pequeñoPaso>=50){
                                equipoAzul[49] ='O';
                                pasosAzules += pequeñoPaso;
                                synchronized(pasosAzules1)
                                {
                                    pasosAzules1.notify();                                
                                }
                                aux = true;
                                medalla();
                                break;
                                
                            }else{
                                equipoAzul[i+pequeñoPaso] ='O';
                                pasosAzules += pequeñoPaso;
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
             for (int i = pasosAzules; i < 50; i++) {
                        if(equipoAzul[i]=='O'){
                            equipoAzul[i] ='_'; 
                            if(i+medioPaso >= 50){
                                equipoAzul[49] ='O';
                                pasosAzules += medioPaso;
                                synchronized(pasosAzules1)
                                {
                                    pasosAzules1.notify();                                
                                }
                                aux = true;
                                medalla();
                                break;
                            }else{
                                equipoAzul[i+medioPaso] ='O';
                                pasosAzules += medioPaso;
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
            for (int i = pasosAzules; i < 50; i++) {
                if(equipoAzul[i]=='O'){
                    equipoAzul[i] = '_'; 
                        if(i+granPaso>=50){
                            equipoAzul[49] ='O';
                            pasosAzules += granPaso;
                            synchronized(pasosAzules1)
                            {
                                pasosAzules1.notify();                                
                            }
                            aux = true;
                            medalla();
                            break;
                            }else{
                                equipoAzul[i+granPaso] ='O';
                                pasosAzules += granPaso;
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
        System.out.println("|||EQUIPO NUMERO 2||");
        System.out.println("||||||||||||||||||||");
    }
}
