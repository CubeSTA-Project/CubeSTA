/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta;

import edu.cubesta.scramble.*;
import edu.cubesta.windows.*;
//import java.util.Scanner;

/**
 *
 * @author julien.gardet yann.droy auxence.araujo
 * @version 1.0 
 */
public class CubeSTA {
    
    /**
     * Varibale globale
     */
    
    static char[][] cubeGUI = new char[Character.MAX_VALUE][10];
    static char tmp;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner read = new Scanner(System.in);
        //System.out.println("Entrer le nombre de mouvements pour le mélange :");
        CubeGUI cube = new CubeGUI();
        AlgoMaker algo = new AlgoMaker(/*read.nextInt()*/20);
        cube.scrambleCubeGUI(algo.getScramble());
        //cube.displayCube(algo.getScramble());
        new Windows(cube.getCubeGUI(),algo.getScramble());
    }
   
    
}
