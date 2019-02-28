/**
 * @author Galimberti_Francesco
 *
 * @version 1.0  
 */
package cavalli;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Galimberti_Francesco
 *
 * @brief La classe CorsaCavalli permette di simulare una gara tra 5 cavalli La
 * classe collabora con le classi: ThCorsa, DatiCondivisi, Semaforo
 */
public class CorsaCavalli {

    /**
     * @author Galimberti_Francesco
     *
     * @brief Il metodo permette all'utente di scegliere su quale cavallo
     * puntare. Crea e avvia i 5 Thread che corrispondono ai 5 cavalli. Quando
     * l'utente digita il tasto ENTER, la gara termina, viene visualizzato il
     * cavallo vincitore (in base al numero di galoppi) e verificata la vittoria
     * o meno dell'utente. Un sesto Thread visualizza i galoppi dei cavalli fino
     * a quando la gara termina Viene garantita sincronizzazione e mutua
     * esclusione con l'utilizzo di 3 semafori.
     */
    public static void main(String[] args) {

        try {
            java.io.BufferedReader console = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            Scanner input = new Scanner(System.in);

            DatiCondivisi dati = new DatiCondivisi();
            Semaforo sincro1 = new Semaforo(1);
            Semaforo sincro2 = new Semaforo(0);

            ThCorsa Clop1 = new ThCorsa(1, dati, sincro1, sincro2);
            ThCorsa Clop2 = new ThCorsa(2, dati, sincro1, sincro2);
            ThCorsa Clop3 = new ThCorsa(3, dati, sincro1, sincro2);
            ThCorsa Clop4 = new ThCorsa(4, dati, sincro1, sincro2);
            ThCorsa Clop5 = new ThCorsa(5, dati, sincro1, sincro2);
            ThVisualizza tv = new ThVisualizza(dati, sincro1, sincro2);

            System.out.println("Su che cavallo punti? 1/2/3/4/5");
            int numCav = input.nextInt();

            tv.start();
            Clop1.start();
            Clop2.start();
            Clop3.start();
            Clop4.start();
            Clop5.start();

            String s = "";
            while (true) {
                s = console.readLine();
                if (s.equals("")) {
                    break;
                }
            }
            if (s.equals("")) {
                Clop1.interrupt();
                Clop2.interrupt();
                Clop3.interrupt();
                Clop4.interrupt();
                Clop5.interrupt();
            }            
            //attendi
            dati.waitSem1();
            dati.waitSem2();
            dati.waitSem3();
            dati.waitSem4();
            dati.waitSem5();
            
            if(ThVisualizza.currentThread().isAlive()){
                sincro1.Signal();
                tv.interrupt();
            }
            
            int max = 0;
            int nCavallo = 0;
            if (dati.getnClop1() > max) {
                nCavallo = 1;
                max = dati.getnClop1();
            }
            if (dati.getnClop2() > max) {
                nCavallo = 2;
                max = dati.getnClop2();
            }
            if (dati.getnClop3() > max) {
                nCavallo = 3;
                max = dati.getnClop3();
            }
            if (dati.getnClop4() > max) {
                nCavallo = 4;
                max = dati.getnClop4();
            }
            if (dati.getnClop5() > max) {
                nCavallo = 5;
                max = dati.getnClop5();
            }

            System.out.println("Cavallo vincitore: " + nCavallo);
            System.out.println("Cavallo puntato: " + numCav);

            if (numCav == nCavallo) {
                System.out.println("WINNER");
            } else {
                System.out.println("LOSER");
            }

            System.out.println("Alla prossima!");

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(CorsaCavalli.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
