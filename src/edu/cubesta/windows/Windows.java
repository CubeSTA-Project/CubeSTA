/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.windows;

import java.awt.Image;
import java.awt.Toolkit;
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
        this.setTitle("CubeSTA");
        this.setSize(520, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        this.setContentPane(new Graphs(cubeGUI,algo));
        this.setVisible(true);
    }
    
}
