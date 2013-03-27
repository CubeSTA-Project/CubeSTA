/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.timer;

/**
 *
 * @author auxence.araujo
 */
public class Timer {
    
    /**
     * Variable Globale
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
     * Permet de démarrer le chronometre
     */
    
    public void start() {
        tempsStart = System.currentTimeMillis();
    }
    
    /**
     * Permet d'arreter le chronomètre
     */
    
    public void stop() {
        tempsStop = System.currentTimeMillis();
    }
    
    public int getTime(){
        long timeDone = tempsStop - tempsStart;
        timeDone = timeDone / 10; //ja-poney
        int time = (int)(timeDone/6000)*10000 + (int)(timeDone%6000); // temps de format (pour un temps de 1'45.35 affiche 14535 au lieu de 105350 ms) [humain readable]
        return  time ;
    }
}

