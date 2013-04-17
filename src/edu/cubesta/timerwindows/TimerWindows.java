/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.timerwindows;

import edu.cubesta.scramble.AlgoMaker;
import edu.cubesta.scramble.CubeGUI;
import java.awt.*;
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
        this.setTitle("CubeSTA");
        this.setSize(240, 435);
        this.setLocation(660, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        TimerGraphs pan = new TimerGraphs();
        content.setLayout(cl);
        content.add(pan, "cube");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new Listener());
        while(true){
            changeScreen();
        }
    }
    
    /**
     * 
     */
     public static void changeScreen(){
            TimerGraphs panel = new TimerGraphs();
            content.add(panel, "timer");
            cl.show(content, "timer");
     }
}
