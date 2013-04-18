/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.timerwindows;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author julien.gardet
 */
public class TimerWindows extends JFrame {
    
    /**
     * Variable Globale
     */

    static CardLayout cl = new CardLayout();
    static JPanel content = new JPanel();
        
    /**
     * Permet d'initialiser une fenêtre
     * @param cubeGUI
     * Le cube à afficher
     * @param algo 
     * Le texte du mélange à afficher
     */
    
    public TimerWindows(){
        this.setTitle("Chronomètre");
        this.setSize(240, 435);
        this.setLocation(660, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        TimerGraphs pan = new TimerGraphs();
        content.setLayout(cl);
        content.add(pan, "timer");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new Listener());
        refreshScreen();
        
    }
    
    /**
     * 
     */
     public static void refreshScreen(){
         while(true){
            try {
                TimerGraphs panel = new TimerGraphs();
                content.add(panel, "timer");
                cl.show(content, "timer");
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimerWindows.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
}
