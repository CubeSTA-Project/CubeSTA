/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.timer;

/**
 * Le chronomètre de notre programme
 * @author auxence.araujo
 */
public class Timer {
    
    /**
     * Variables globales
     */
    
    long tempsStart;
    long tempsStop;
    
    /**
     * Permet d'initialiser un chronomètre
     */

    public Timer() {
            tempsStart = 0;
            tempsStop = 0;
    }
    
    /**
     * Permet de démarrer le chronomètre
     */
    
    public void start(){
        tempsStart = System.currentTimeMillis();
    }
    
    /*
     * Permet de stopper le chronomètre et de recueillir le temps sous le format souhaité :
     * pour un temps de 1:45.35 on prend 14535 [humain readable]
     */
    
    public int stop(){
        tempsStop = System.currentTimeMillis() - tempsStart;
        int time = (int)((tempsStop/10)/6000)*10000 + (int)((tempsStop/10)%6000);
        return  time;
    }
}
