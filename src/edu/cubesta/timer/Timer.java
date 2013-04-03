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
        tempsStop = System.currentTimeMillis();
        long diff = tempsStop - tempsStart;
        int time = (int)((diff/10)/6000)*10000 + (int)((diff/10)%6000);
        return  time;
    }
    
    public void reset(){
        tempsStart = 0;
        tempsStop = 0;
    }
    
    public int currentTime(){
        long diff = ((tempsStop != 0 )? tempsStop : System.currentTimeMillis()) - tempsStart;
        int time = (int)((diff/10)/6000)*10000 + (int)((diff/10)%6000);
        return  time; 
    }
    
    public String time2string(int time){
        String zeroSeconde = "";
        if((time/100-(time/10000*10000)) <= 9){
            zeroSeconde = "0";
        }
        String zeroMillis = "";
        if(time%100 <= 9){
            zeroMillis = "0";
        }
        String text = time/10000 + ":" + zeroSeconde + (time/100-(time/10000*10000)) + "." + zeroMillis + time%100;
        return text;
    }
    
}
