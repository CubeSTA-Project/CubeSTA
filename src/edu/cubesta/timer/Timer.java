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

    public Timer() {
       long T = System.currentTimeMillis();
        double X = T/1000;
        System.out.println(X);
        long U = System.currentTimeMillis();
        double Y = U/1000;
        System.out.println(Y);
        double Ts = (Y/X);  
        System.out.println(Ts);
       }
    }

