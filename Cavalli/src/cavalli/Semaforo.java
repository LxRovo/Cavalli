/**
 * @author Galimberti_Francesco
 *
 * @version 1.0
 */
package cavalli;

/**
 * @author Galimberti_Francesco
 *
 * @brief La classe Semaforo permette di garantire la mutua esclusione
 */
public class Semaforo {

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione della variabile intera del semaforo
     */
    int valore;

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo costruttore di default
     *
     * @param initial Il parametro permette di passare al metodo un valore
     * intero con cui inizializzare la variabile intera del semaforo
     */
    public Semaforo(int initial) {
        valore = initial;
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo che decremeta la varibile intera del semaforo, se il valore
     * è negativo, il Thread che l'ha eseguita va in wait
     */
    synchronized public void Wait() {
        while (valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valore--;
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo che incrementa la varibile intera del semaforo e notifica
     * l'incremeto
     */
    synchronized public void Signal() {
        valore++;
        notify();
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo che decremeta la varibile intera del semaforo, se il valore
     * è negativo, il Thread che l'ha eseguita va in wait (corrisponde al metodo
     * Wait())
     */
    synchronized public void P() {
        while (valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valore--;
    }

    /**
     * @author Galimberti_Francesco
     *
     * @brief Metodo che incrementa la varibile intera del semaforo e notifica
     * l'incremeto (corrisponde al metodo Signal())
     */
    synchronized public void V() {
        valore++;
        notify();
    }
}
