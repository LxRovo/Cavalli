/**
 * @author Galimberti_Francesco
 *
 * @version 1.0
 */
package cavalli;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Galimberti_Francesco
 *
 * @brief Classe ThCorsa, si occupa di simulare il galoppo di un cavallo
 */
public class ThCorsa extends Thread {

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero del cavallo
     */
    private int nThread;

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo puntatore che servisà a salvare il numero di
     * galoppi del cavallo
     */
    private DatiCondivisi ptrDati;

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo puntatore che servirà a garantire la
     * sincronizzazione tra i Thread
     */
    private Semaforo ptrSincro1;
    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo puntatore che servirà a garantire la
     * sincronizzazione tra i Thread
     */
    private Semaforo ptrSincro2;

    /**
     * @author Galimberti_Francesco
     *
     * @brief Costruttore con parametri che permette di inizializzare il numero
     * del cavallo, un oggetto nel quale verranno memorizzate informazione sul
     * cavallo e l'utilizzo o meno dello yeld e dello sleep.
     *
     * @param nT il parametro serve per passare al metodo un valore intero per
     * inizializzare l'attributo che memorizza il numero del cavallo
     * @param dati il parametro serve a passare al metodo un puntatore
     * DatiCondivisi dove verrà memorizzato il numero di galoppi del cavallo
     * @param sincro1 il parametro serve a passare al metodo un puntatore Semaforo
     * per garantire la sincronizzazione
     * @param sincro2 il parametro serve a passare al metodo un puntatore Semaforo
     * per garantire la sincronizzazione
     */
    public ThCorsa(int nT, DatiCondivisi dati,Semaforo sincro1, Semaforo sincro2) {
        this.nThread = nT;
        this.ptrDati = dati;
        this.ptrSincro1 = sincro1;
        this.ptrSincro2 = sincro2;
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo rappresentante il main del Thread
     *
     * Il metodo serve a simulare il galoppo del cavallo. Il cavallo continua a
     * galoppare e il numero dei galoppi incrementato, fino a quando la gara
     * termina. Dopo ogni passo il Thread salva il numero di galoppi.
     */
    @Override
    public void run() {
        int nC = 0;
        try {
            while (true) {
                nC++;

                ptrSincro2.Wait();
                switch (this.nThread) {
                    case 1:
                        ptrDati.setnClop1(nC);
                        break;

                    case 2:
                        ptrDati.setnClop2(nC);
                        break;

                    case 3:
                        ptrDati.setnClop3(nC);
                        break;

                    case 4:
                        ptrDati.setnClop4(nC);
                        break;

                    case 5:
                        ptrDati.setnClop5(nC);
                        break;
                }
                ptrSincro1.Signal();

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                Thread.sleep((int) (Math.random() * 10));

            }

        } catch (InterruptedException ex) {
            //Logger.getLogger(ThCorsa.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fine corsa");            
        }
        
        switch (this.nThread) {
                    case 1:
                        ptrDati.signalSem1();
                        break;

                    case 2:
                        ptrDati.signalSem2();
                        break;

                    case 3:
                        ptrDati.signalSem3();
                        break;

                    case 4:
                        ptrDati.signalSem4();
                        break;

                    case 5:
                        ptrDati.signalSem5();
                        break;
                }

    }

}
