    package com.mycompany.relevos;


    import static com.mycompany.relevos.Principal.equipoAmarrilo;
    import static com.mycompany.relevos.Principal.generarNumero;
    import static com.mycompany.relevos.Principal.imprimir;
    import static com.mycompany.relevos.Principal.pasosAmarillos;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    /**
     *
     * @author duvan
     */
    public class HiloP1 extends Thread {
        /**
         * variable que guarda al equipo al cual pertenece la persona
         */
        private String equipo;
        private char[] equipoAmarillo;
        private int caido;
        private int pequeñoPaso;
        private int medioPaso;
        private int granPaso;
        private Integer pa;
        private Boolean aux = false;
        /**
         * Constructor que inicializa los atributos locales para la clase
         * @param equipo
         * @param caido
         * @param pequeñoPaso
         * @param medioPaso
         * @param granPaso
         * @param pasosAma
         * @param equipoAmarillo 
         */
        public HiloP1(String equipo, int caido, int pequeñoPaso, int medioPaso, int granPaso, Integer pasosAma, char[] equipoAmarillo) {
            this.equipoAmarillo = equipoAmarillo;
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
            equipoAmarrilo[0]='D';
            equipoAmarrilo[20]='S';
            equipoAmarrilo[40]='C';
            while(!aux){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(HiloP1.class.getName()).log(Level.SEVERE, null, ex);
                }
                int numero = generarNumero();
                if(numero == 0){
                //aux = true;    
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
                        if(equipoAmarrilo[i]=='D'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+pequeñoPaso>=20){
                                equipoAmarrilo[19] ='D';
                                pasosAmarillos += pequeñoPaso;
                                synchronized(pa)
                                {
                                    pa.notify();
                                }
                                aux = true;
                                break;
                            }else{
                                equipoAmarrilo[i+pequeñoPaso] ='D';
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
             for (int i = 0; i < 50; i++) {
                        if(equipoAmarrilo[i]=='D'){
                            equipoAmarrilo[i] ='_'; 
                            if(i+medioPaso >= 20){
                                equipoAmarrilo[19] ='D';
                                pasosAmarillos += medioPaso;
                                synchronized(pa)
                                {
                                    //pasosAmarillos += medioPaso;
                                    pa.notify();
                                }
                                aux = true;
                                break;
                            }else{
                                equipoAmarrilo[i+medioPaso] ='D';
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
            for (int i = 0; i < 50; i++) {
                if(equipoAmarrilo[i]=='D'){
                    equipoAmarrilo[i] = '_'; 
                        if(i+granPaso>=20){
                            equipoAmarrilo[19] ='D';
                            pasosAmarillos += granPaso;
                            synchronized(pa)
                            {
                                //pasosAmarillos += granPaso;
                                pa.notify();
                            }
                            aux = true;
                            break;
                            }else{
                                equipoAmarrilo[i+granPaso] ='D';
                                pasosAmarillos += granPaso;
                                break;
                        }//else
                }//if
            }//for
        }
    }
