/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.cubewindows;

import edu.cubesta.scramble.AlgoMaker;
import edu.cubesta.scramble.CubeGUI;
import edu.cubesta.timerwindows.Listener;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author julien.gardet
 */
public class CubeWindows extends JFrame {
    
    /**
     * Variable Globale
     */
    
    static char[][] cubeGUI;
    static char[][] algoGUI;
    static CardLayout cl = new CardLayout();
    static JPanel content = new JPanel();
        
    /**
     * Permet d'initialiser une fenêtre
     * @param cubeGUI
     * Le cube à afficher
     * @param algo 
     * Le texte du mélange à afficher
     */
    
    public CubeWindows(){
        this.setTitle("Mélange - CubeSTA");
        this.setSize(550, 450);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        createCube();
        CubeGraphs pan = new CubeGraphs(cubeGUI,algoGUI);
        content.setLayout(cl);
        content.add(pan, "cube");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new Listener());
    }
    
    /**
     * 
     */
    
    public static void createCube(){
        CubeGUI cube = new CubeGUI();
        AlgoMaker algo = new AlgoMaker(/*read.nextInt()*/22);
        cube.scrambleCubeGUI(algo.getScramble());
        cubeGUI = cube.getCubeGUI();
        algoGUI = algo.getScramble();
    }
    
    /**
     * 
     */
     public static void changeScreen(){
            createCube();
            CubeGraphs panel = new CubeGraphs(cubeGUI,algoGUI);
            content.add(panel, "cube");
            cl.show(content, "cube");
     }
}
