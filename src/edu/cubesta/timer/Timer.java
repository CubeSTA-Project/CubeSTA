/* Project : CubeSTA
 * Location : edu.cubesta.timer
 * Class : Timer.java
 */
package edu.cubesta.timer;

/**
 * Permet de gérer le fonctionnement du chronomètre
 * @author auxence.araujo
 */
public class Timer {
    
    /**
     * Variables globales
     */
    
    public static long tempsStart;
    public static long tempsStop;
    
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
    
    public static void start(){
        tempsStart = System.currentTimeMillis();
    }
    
    /*
     * Permet de stopper le chronomètre et de recueillir le temps sous le format souhaité :
     * pour un temps de 1:45.35 on prend 14535 ([i]ssmm)[humain readable]
     */
    
    public static int stop(){
        tempsStop = System.currentTimeMillis();
        long diff = tempsStop - tempsStart;
        int time = (int)((diff/10)/6000)*10000 + (int)((diff/10)%6000);
        return  time;
    }
    
    /**
     * Remet à zéro le chronomètre
     */
    
    public static void reset(){
        tempsStart = 0;
        tempsStop = 0;
    }
    
    /**
     * Permet d'obtenir le temps actuel du chronomètre
     * @return 
     * retourne un temps du type [i]ssmm (human readable)
     */
    
    public static int currentTime(){
        long diff;
        if(tempsStart == 0){
            diff = 0;
        }else{
            diff = ((tempsStop != 0 )? tempsStop : System.currentTimeMillis()) - tempsStart;
        }
        int time = (int)((diff/10)/6000)*10000 + (int)((diff/10)%6000);
        return  time; 
    }
    
    /**
     * Convertie un temps au format [i]ssmm en format [i]:ss.mm
     * @param time
     * temps au format [i]ssmm
     * @return 
     * retourne un temps au format [i]:ss.mm
     */
    
    public static String time2string(int time){
        time = (time < 0) ? -time : time ;
        String zeroSeconde = "";
        if((time/100-(time/10000*100)) <= 9){
            zeroSeconde = "0";
        }
        String zeroMillis = "";
        if(time%100 <= 9){
            zeroMillis = "0";
        }
        String text = time/10000 + ":" + zeroSeconde + (time/100-(time/10000*100)) + "." + zeroMillis + time%100;
        return text;
    }
    
}