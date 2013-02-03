/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cubesta;

import edu.cubesta.scramble.*;
import java.util.Scanner;
//import edu.cubesta.windows.*;

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
        Scanner read = new Scanner(System.in);
        System.out.println("Entrer le nombre de mouvement pour le mélange ?");
        CubeGUI cube = new CubeGUI();
        AlgoMaker algo = new AlgoMaker(read.nextInt());
        cube.scrambleCubeGUI(algo.getScramble());
        cube.displayCube(algo.getScramble());
        //Windows win = new Windows();
    }
   
    
}
