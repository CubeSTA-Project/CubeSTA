/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.windows;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author julien
 */
public class Windows extends JFrame {
    
    /**
     * Permet d'initialiser une fenêtre
     */
    
    public Windows(){
        this.setTitle("Ma première fenêtre Java");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);            
        
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.ORANGE);
        this.setContentPane(panel);
        this.setVisible(true);
    }
}
