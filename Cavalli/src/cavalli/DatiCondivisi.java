/**
 * @author Galimberti_Francesco
 *
 * @version 1.0
 */
package cavalli;

import java.util.concurrent.Semaphore;

/**
 * @author Galimberti_Francesco
 *
 * @brief Classe DatiCondivisi, si occupa di memorizzare e restituire il numero
 * di galoppi di ogni cavallo della gara.
 */
public class DatiCondivisi {

    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero di galoppi del
     * cavallo1
     */
    private int nClop1;
    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero di galoppi del
     * cavallo2
     */
    private int nClop2;
    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero di galoppi del
     * cavallo3
     */
    private int nClop3;
    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero di galoppi del
     * cavallo4
     */
    private int nClop4;
    /**
     * @author Galimberti_Francesco
     *
     * Dichiarazione dell'attributo che memorizza il numero di galoppi del
     * cavallo5
     */
    private int nClop5;

    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;    
    private Semaphore sem5;
    
    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo costruttore con parametri che inizializza a 0 i numeri di galoppi di
     * ogni cavallo.
     */
    public DatiCondivisi() {
        this.nClop1 = 0;
        this.nClop2 = 0;
        this.nClop3 = 0;
        this.nClop4 = 0;
        this.nClop5 = 0;
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        sem4 = new Semaphore(0);
        sem5 = new Semaphore(0);
    }
    
    
    public synchronized void visualizzaCavalli() {
            System.out.println("Numero galoppi:");            
            System.out.println("Clop1 --> " + getnClop1());
            System.out.println("Clop2 --> " + getnClop2());
            System.out.println("Clop3 --> " + getnClop3());
            System.out.println("Clop4 --> " + getnClop4());
            System.out.println("Clop5 --> " + getnClop5());      
    }
    public void waitSem1() throws InterruptedException {
        sem1.acquire();
    }
    public void signalSem1() {
        sem1.release();
    }
    public void waitSem2() throws InterruptedException {
        sem2.acquire();
    }
    public void signalSem2() {
        sem2.release();
    }
    public void waitSem3() throws InterruptedException {
        sem3.acquire();
    }
    public void signalSem3() {
        sem3.release();
    }
    public void waitSem4() throws InterruptedException {
        sem4.acquire();
    }
    public void signalSem4() {
        sem4.release();
    }
    public void waitSem5() throws InterruptedException {
        sem5.acquire();
    }
    public void signalSem5() {
        sem5.release();
    }
    


    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo accessore di default che restituisce il numero di galoppi 
     * del cavallo1
     * @return nClop1 viene restituito un numero intero che indica il numero di
     * galoppi del cavallo1
     */
    public synchronized int getnClop1() {
        return nClop1;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo accessore di default che restituisce il numero di galoppi 
     * del cavallo2
     * @return nClop2 viene restituito un numero intero che indica il numero di
     * galoppi del cavallo3
     */
    public synchronized int getnClop2() {
        return nClop2;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo accessore di default che restituisce il numero di galoppi 
     * del cavallo4
     * @return nClop3 viene restituito un numero intero che indica il numero di
     * galoppi del cavallo3
     */
    public synchronized int getnClop3() {
        return nClop3;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo accessore di default che restituisce il numero di galoppi 
     * del cavallo4
     * @return nClop4 viene restituito un numero intero che indica il numero di
     * galoppi del cavallo4
     */
    public synchronized int getnClop4() {
        return nClop4;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo accessore di default che restituisce il numero di galoppi 
     * del cavallo5
     * @return nClop5 viene restituito un numero intero che indica il numero di
     * galoppi del cavallo5
     */
    public synchronized int getnClop5() {
        return nClop5;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo modificatore di default che modifica il numero di galoppi 
     * del cavallo1
     * @param nClop1 il paramtero serve a passare al metodo un valore intero, 
     * con cui modificare il valore dell'attributo nClop1, che corrisponde al 
     * numero di galoppi del cavallo1
     */
    public synchronized void setnClop1(int nClop1) {
        this.nClop1 = nClop1;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo modificatore di default che modifica il numero di galoppi 
     * del cavallo2
     * @param nClop2 il paramtero serve a passare al metodo un valore intero, 
     * con cui modificare il valore dell'attributo nClop2, che corrisponde al 
     * numero di galoppi del cavallo2
     */
    public synchronized void setnClop2(int nClop2) {
        this.nClop2 = nClop2;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo modificatore di default che modifica il numero di galoppi 
     * del cavallo3
     * @param nClop3 il paramtero serve a passare al metodo un valore intero, 
     * con cui modificare il valore dell'attributo nClop3, che corrisponde al 
     * numero di galoppi del cavallo3
     */
    public synchronized void setnClop3(int nClop3) {
        this.nClop3 = nClop3;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo modificatore di default che modifica il numero di galoppi 
     * del cavallo4
     * @param nClop4 il paramtero serve a passare al metodo un valore intero, 
     * con cui modificare il valore dell'attributo nClop4, che corrisponde al 
     * numero di galoppi del cavallo4
     */
    public synchronized void setnClop4(int nClop4) {
        this.nClop4 = nClop4;
    }

    /**
     * @author Galimberti_Francesco
     * 
     * @brief Metodo modificatore di default che modifica il numero di galoppi 
     * del cavallo5
     * @param nClop5 il paramtero serve a passare al metodo un valore intero, 
     * con cui modificare il valore dell'attributo nClop5, che corrisponde al 
     * numero di galoppi del cavallo5
     */
    public synchronized void setnClop5(int nClop5) {
        this.nClop5 = nClop5;
    }

}
