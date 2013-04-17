/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta.windows;

import edu.cubesta.scramble.AlgoMaker;
import edu.cubesta.scramble.CubeGUI;
import edu.cubesta.timer.ClavierListener;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 *
 * @author julien.gardet
 */
public class Windows extends JFrame {
    
    /**
     * Variable Globale
     */
    
    char[][] cubeGUI;
    char[][] algoGUI;
    /**
     * Permet d'initialiser une fenêtre
     * @param cubeGUI
     * Le cube à afficher
     * @param algo 
     * Le texte du mélange à afficher
     */
    
    public Windows(){
        this.setTitle("CubeSTA");
        this.setSize(520, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        Image icon;
        icon = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("edu/cubesta/resources/favicon.png"));
        this.setIconImage(icon);
        //Pan 1 et 2
            createCube();
            Graphs pan = new Graphs(cubeGUI,algoGUI);
            //createCube();
            //Graphs pan2 = new Graphs(cubeGUI,algoGUI);
            //createCube();
            //Graphs pan3 = new Graphs(cubeGUI,algoGUI);
        CardLayout cl = new CardLayout();
        JPanel content = new JPanel();
            content.setLayout(cl);
            content.add(pan, "1");
            //content.add(pan2, "2");
            //content.add(pan3, "3");
        this.setContentPane(content);
        this.setVisible(true);
        this.addKeyListener(new ClavierListener());
        while(true){
            Scanner read = new Scanner(System.in);
            String txt = read.nextLine();
            cl.next(content);
            createCube();
            Graphs panel = new Graphs(cubeGUI,algoGUI);
            content.add(panel, "3");
        }
    }
    
    /**
     * 
     */
    
    public void createCube(){
        CubeGUI cube = new CubeGUI();
        AlgoMaker algo = new AlgoMaker(/*read.nextInt()*/22);
        cube.scrambleCubeGUI(algo.getScramble());
        cubeGUI = cube.getCubeGUI();
        algoGUI = algo.getScramble();
    }
    
}
