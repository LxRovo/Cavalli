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
 * @brief La classe ThVisualizza rappresenta un Thread che visualizza il
 * contenuto dele variabili condivise dai Thread
 */
public class ThVisualizza extends Thread {

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo puntatore che servirà a memorizzare il
     * valore incrementato dal Thread
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
     * @brief Metodo costruttore di default
     *
     * @param ptrDati il parametro serve a passare al metodo un puntatore
     * DatiCondivisi dove verrà memorizzato il valore incrementato
     * @param sincro1 il parametro serve a passare al metodo un puntatore
     * Semaforo per garantire la sincronizzazione
     * @param sincro2 il parametro serve a passare al metodo un puntatore
     * Semaforo per garantire la sincronizzazione
     */
    public ThVisualizza(DatiCondivisi ptrDati, Semaforo sincro1, Semaforo sincro2) {
        this.ptrDati = ptrDati;
        this.ptrSincro1 = sincro1;
        this.ptrSincro2 = sincro2;
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Il metodo permette di visualizzare il contenuto delle variabili
     * condivise(i galoppi)
     */
    public void run() {

        while (true) {
            ptrSincro1.Wait();           
            
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            ptrDati.visualizzaCavalli();
            
            ptrSincro2.Signal();
        }
    }
}
