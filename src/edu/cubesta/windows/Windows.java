/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.windows;

import javax.swing.*;

/**
 *
 * @author julien
 */
public class Windows extends JFrame {
    
    /**
     * Permet d'initialiser une fenêtre
     */
    
    public Windows(char[][] cubeGUI, char[][] algo){
        this.setTitle("Ma première fenêtre Java");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
        this.setContentPane(new Graphs(cubeGUI,algo));
        this.setVisible(true);
    }
    
}
