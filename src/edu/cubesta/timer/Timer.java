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
    long tempsCurrent;
    
    /**
     * Permet d'initialiser un chronomètre
     */

    public Timer() {
            tempsStart = 0;
            tempsCurrent = 0;
    }
    
    /**
     * Permet de démarrer le chronomètre
     */
    
    public void start(){
        tempsStart = System.currentTimeMillis();
    }
    
    /*
     * Permet de recueillir le temps sous le format souhaité :
     * pour un temps de 1:45.35 on affiche 14535) [humain readable]
     */
    
    public int stop(){
        tempsCurrent = System.currentTimeMillis() - tempsStart;
        int time = (int)((tempsCurrent/10)/6000)*10000 + (int)((tempsCurrent/10)%6000);
        return  time;
    }
}
