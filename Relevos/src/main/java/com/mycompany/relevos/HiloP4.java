package com.mycompany.relevos;
    import static com.mycompany.relevos.Principal.generarNumero2;
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
public class HiloP4 extends Thread{
    /**
     * variable que captura el equipo al cual pertenece la persona
     */
    private String equipo;
    private char[] equipoAzul;
    private int caido;
    private int pequeñoPaso;
    private int medioPaso;
    private int granPaso;
    private Integer pa;
    private Boolean aux = false;
    /**
     * construcotr que permite instanciar la clase
     * @param equipo
     * @param caido
     * @param pequeñoPaso
     * @param medioPaso
     * @param granPaso
     * @param pasosAma
     * @param equipoAzul 
     */
    public HiloP4(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer pasosAma, char[] equipoAzul) {
        this.equipoAzul = equipoAzul;
        this.equipo = equipo;
        this.caido = caido;
        this.pequeñoPaso = pequeñoPaso;
        this.medioPaso = medioPaso;
        this.granPaso = granPaso;
        this.pa = pasosAma;
        }
        /**
        * Metodo que hace un recorrido de los vectores el cual cuando 
        * cierta variable llega hasta cierto punto, notifica al siguiente hilo en que
        * momento debe arrancar e iniciar el mismo proceso
        */
        @Override
        public void run()
        {
            equipoAzul[0]='A';
            equipoAzul[20]='G';
            equipoAzul[40]='O';
            while(!aux){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloP1.class.getName()).log(Level.SEVERE, null, ex);
                }
                int numero = generarNumero2();
                if(numero == 0){
                //aux = true;    
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
                        if(equipoAzul[i]=='A'){
                            equipoAzul[i] ='_'; 
                            if(i+pequeñoPaso>=20){
                                equipoAzul[19] ='A';
                                pasosAzules += pequeñoPaso;
                                synchronized(pa)
                                {
                                    pa.notify();
                                }
                                aux = true;
                                break;
                            }else{
                                equipoAzul[i+pequeñoPaso] ='A';
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
             for (int i = 0; i < 50; i++) {
                        if(equipoAzul[i]=='A'){
                            equipoAzul[i] ='_'; 
                            if(i+medioPaso >= 20){
                                equipoAzul[19] ='A';
                                pasosAzules += medioPaso;
                                synchronized(pa)
                                {
                                    //pasosAmarillos += medioPaso;
                                    pa.notify();
                                }
                                aux = true;
                                break;
                            }else{
                                equipoAzul[i+medioPaso] ='A';
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
            for (int i = 0; i < 50; i++) {
                if(equipoAzul[i]=='A'){
                    equipoAzul[i] = '_'; 
                        if(i+granPaso>=20){
                            equipoAzul[19] ='A';
                            pasosAzules += granPaso;
                            synchronized(pa)
                            {
                                //pasosAmarillos += granPaso;
                                pa.notify();
                            }
                            aux = true;
                            break;
                            }else{
                                equipoAzul[i+granPaso] ='A';
                                pasosAzules += granPaso;
                                break;
                        }//else
                }//if
            }//for
        }
}
